package com.vaadin.starter.bakery.ui.views.storefront;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.starter.bakery.app.security.CurrentUser;
import com.vaadin.starter.bakery.backend.data.entity.Order;
import com.vaadin.starter.bakery.backend.service.OrderService;
import com.vaadin.starter.bakery.ui.crud.EntityPresenter;
import com.vaadin.starter.bakery.ui.dataproviders.OrdersGridDataProvider;
import com.vaadin.starter.bakery.ui.dataproviders.OrdersGridDataProvider.OrderFilter;
import com.vaadin.starter.bakery.ui.views.storefront.beans.OrderCardHeader;

import static com.vaadin.starter.bakery.ui.utils.BakeryConst.PAGE_STOREFRONT_ORDER_EDIT;

/**
 * Presenter para a StorefrontView, gerenciando lógica de apresentação e interação de pedidos.
 * <p>
 * Responsável por filtrar, atualizar e manipular pedidos exibidos na Storefront.
 * </p>
 *
 * @author GitHub Copilot
 */
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderPresenter {

	/**
	 * Gerador de cabeçalhos para os cards de pedido.
	 */
	private OrderCardHeaderGenerator headersGenerator;
	/**
	 * Referência à view associada.
	 */
	private StorefrontView view;

	private final EntityPresenter<Order, StorefrontView> entityPresenter;
	private final OrdersGridDataProvider dataProvider;
	private final CurrentUser currentUser;
	private final OrderService orderService;

	/**
	 * Construtor do presenter de pedidos.
	 *
	 * @param orderService serviço de pedidos
	 * @param dataProvider provedor de dados da grid
	 * @param entityPresenter presenter de entidade
	 * @param currentUser usuário atual
	 */
	@Autowired
	OrderPresenter(OrderService orderService, OrdersGridDataProvider dataProvider,
			EntityPresenter<Order, StorefrontView> entityPresenter, CurrentUser currentUser) {
		this.orderService = orderService;
		this.entityPresenter = entityPresenter;
		this.dataProvider = dataProvider;
		this.currentUser = currentUser;
		headersGenerator = new OrderCardHeaderGenerator();
		headersGenerator.resetHeaderChain(false);
		dataProvider.setPageObserver(p -> headersGenerator.ordersRead(p.getContent()));
	}

	/**
	 * Inicializa o presenter com a view associada.
	 *
	 * @param view a StorefrontView
	 */
	void init(StorefrontView view) {
		this.entityPresenter.setView(view);
		this.view = view;
		view.getGrid().setDataProvider(dataProvider);
		view.getOpenedOrderEditor().setCurrentUser(currentUser.getUser());
		view.getOpenedOrderEditor().addCancelListener(e -> cancel());
		view.getOpenedOrderEditor().addReviewListener(e -> review());
		view.getOpenedOrderDetails().addSaveListenter(e -> save());
		view.getOpenedOrderDetails().addCancelListener(e -> cancel());
		view.getOpenedOrderDetails().addBackListener(e -> back());
		view.getOpenedOrderDetails().addEditListener(e -> edit());
		view.getOpenedOrderDetails().addCommentListener(e -> addComment(e.getMessage()));
	}

	/**
	 * Obtém o cabeçalho do pedido pelo seu ID.
	 *
	 * @param id ID do pedido
	 * @return cabeçalho do pedido
	 */
	OrderCardHeader getHeaderByOrderId(Long id) {
		return headersGenerator.get(id);
	}

	/**
	 * Altera o filtro de exibição dos pedidos.
	 *
	 * @param filter filtro a ser aplicado
	 * @param showPrevious indica se pedidos anteriores devem ser exibidos
	 */
	public void filterChanged(String filter, boolean showPrevious) {
		headersGenerator.resetHeaderChain(showPrevious);
		dataProvider.setFilter(new OrderFilter(filter, showPrevious));
	}

	/**
	 * Trata a navegação para um pedido específico, carregando seus dados.
	 *
	 * @param id ID do pedido
	 * @param edit indica se o pedido deve ser aberto em modo de edição
	 */
	void onNavigation(Long id, boolean edit) {
		entityPresenter.loadEntity(id, e -> open(e, edit));
	}

	/**
	 * Cria um novo pedido e o abre para edição.
	 */
	void createNewOrder() {
		open(entityPresenter.createNew(), true);
	}

	/**
	 * Cancela a edição ou criação do pedido atual.
	 */
	void cancel() {
            entityPresenter.cancel(this::close, () -> view.setOpened(true));
	}

	/**
	 * Fecha o editor de pedidos sem notificações.
	 */
	void closeSilently() {
		entityPresenter.close();
		view.setOpened(false);
	}

	/**
	 * Abre o editor de pedidos para edição.
	 */
	void edit() {
        UI.getCurrent()
                .navigate(String.format(PAGE_STOREFRONT_ORDER_EDIT,
                        entityPresenter.getEntity().getId()));
	}

	/**
	 * Retorna à tela anterior na visualização dos detalhes do pedido.
	 */
	void back() {
		view.setDialogElementsVisibility(true);
	}

	/**
	 * Salva as alterações no pedido e fecha o editor.
	 */
	void review() {
		// Using collect instead of findFirst to assure all streams are
		// traversed, and every validation updates its view
		List<HasValue<?, ?>> fields = view.validate().collect(Collectors.toList());
		if (fields.isEmpty()) {
			if (entityPresenter.writeEntity()) {
				view.setDialogElementsVisibility(false);
				view.getOpenedOrderDetails().display(entityPresenter.getEntity(), true);
			}
		} else if (fields.get(0) instanceof Focusable) {
			((Focusable<?>) fields.get(0)).focus();
		}
	}

	/**
	 * Salva as alterações no pedido.
	 */
	void save() {
		entityPresenter.save(e -> {
			if (entityPresenter.isNew()) {
				view.showCreatedNotification();
				dataProvider.refreshAll();
			} else {
				view.showUpdatedNotification();
				dataProvider.refreshItem(e);
			}
			close();
		});

	}

	/**
	 * Adiciona um comentário ao pedido.
	 *
	 * @param comment o comentário a ser adicionado
	 */
	void addComment(String comment) {
		if (entityPresenter.executeUpdate(e -> orderService.addComment(currentUser.getUser(), e, comment))) {
			// You can only add comments when in view mode, so reopening in that state.
			open(entityPresenter.getEntity(), false);
		}
	}

	private void open(Order order, boolean edit) {
		view.setDialogElementsVisibility(edit);
		view.setOpened(true);

		if (edit) {
			view.getOpenedOrderEditor().read(order, entityPresenter.isNew());
		} else {
			view.getOpenedOrderDetails().display(order, false);
		}
	}

	private void close() {
		view.getOpenedOrderEditor().close();
		view.setOpened(false);
		view.navigateToMainView();
		entityPresenter.close();
	}
}
