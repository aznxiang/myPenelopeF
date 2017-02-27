package GraphicUserInterface;

import java.util.Vector;

import Elements.Dashboard;
import Elements.Group;
import Elements.Message;
import Elements.Project;
import Elements.Task;
import Elements.User;
import Misc.Helper;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicUserInterface extends Application {
	
	private double windowWidth;
	private double windowHeight;
	private FlowPane window;
	private FlowPane contentPane;
	private FlowPane dashboardPane;
	private VBox elementLayout;
	private int dashboardMargin;
	
	private TreeItem<String> projectItem;
	private TreeView<String> projectTreeView;
	private TreeItem<String> taskItem;
	private TreeView<String> taskTreeView;
	private TreeItem<String> groupItem;
	private TreeView<String> groupTreeView;
	private ListView<String> dashboardMessageListView;
	private ObservableList<String> listViewitems;
	
	private Vector<Project> projects;
	private Vector<Task> tasks;
	private Vector<Group> groups;
	
	private ListView<String> groupUserListView;
	private ObservableList<String> groupListViewItem;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	//TODO
	//change this function when recover by JSON will be implemented
	private void getJsonDatas() {
		Project p = new Project("onlyonewhocansendmessageandit'snormal;)");
		p.addObserver(Dashboard.getInstance());
		this.projects = new Vector<Project>();
		this.projects.add(p);
		this.projects.add(new Project("toto"));
		this.projects.add(new Project("tata"));
		this.projects.add(new Project("tete"));
		this.projects.add(new Project("titi"));
		this.projects.add(new Project("tutu"));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(projects.get(i).getName());
			this.projectItem.getChildren().add(newItem);
		}
		
		this.tasks = new Vector<Task>();
		this.tasks.add(new Task("toto"));
		this.tasks.add(new Task("tata"));
		this.tasks.add(new Task("tete"));
		this.tasks.add(new Task("titi"));
		this.tasks.add(new Task("tutu"));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(tasks.get(i).getContent());
			this.taskItem.getChildren().add(newItem);
		}
		
		this.groups = new Vector<Group>();
		Vector<User> users = new Vector<User>();
		users.add(new User("lel"));
		users.add(new User("lol"));
		users.add(new User("lul"));
		users.add(new User("lal"));
		users.add(new User("lil"));
		Vector<User> users2 = new Vector<User>();
		users2.add(new User("lel2"));
		users2.add(new User("lol2"));
		users2.add(new User("lul2"));
		users2.add(new User("lal2"));
		users2.add(new User("lil2"));
		this.groups.add(new Group("toto", users));
		this.groups.add(new Group("tata", users2));
		this.groups.add(new Group("tete", users));
		this.groups.add(new Group("titi", users2));
		this.groups.add(new Group("tutu", users));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(groups.get(i).getName());
			this.groupItem.getChildren().add(newItem);
		}
	}
	
	public void initDashBoard() {		
		this.dashboardPane.getChildren().add(new Label("DASHBOARD"));
		
		this.dashboardMessageListView = new ListView<String>();
		this.listViewitems = FXCollections.observableArrayList();		
		
		this.dashboardMessageListView.setMaxSize(this.windowWidth / 3 + (this.dashboardMargin * 3), this.windowHeight - (this.dashboardMargin * 3));
		this.dashboardMessageListView.setMinSize(this.windowWidth / 3 + (this.dashboardMargin * 3), this.windowHeight - (this.dashboardMargin * 3));
		this.dashboardMessageListView.setItems(this.listViewitems);
		//dashboardPane.setMargin(messages, new Insets(dashboardMargin, dashboardMargin, dashboardMargin, dashboardMargin));
		
		this.dashboardPane.getChildren().add(this.dashboardMessageListView);
	}
	
	public void initComponent() {
		this.window = new FlowPane(Orientation.HORIZONTAL);
		this.elementLayout = new VBox();
		this.contentPane = new FlowPane(Orientation.VERTICAL);
		this.dashboardPane = new FlowPane(Orientation.VERTICAL);
		
		
		this.windowWidth = 1000;
		this.windowHeight = 600;
		this.window.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.dashboardMargin = 20;
		this.projectItem = new TreeItem<String>("Project");
		this.projectTreeView = new TreeView<String>(projectItem);
		this.taskItem = new TreeItem<String>("Tasks");
		this.taskTreeView = new TreeView<String>(taskItem);
		this.groupItem = new TreeItem<String>("Group");
		this.groupTreeView = new TreeView<String>(groupItem);
		
		this.projectTreeView.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		this.taskTreeView.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		this.groupTreeView.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		
		this.elementLayout.getChildren().add(projectTreeView);
		this.elementLayout.getChildren().add(taskTreeView);
		this.elementLayout.getChildren().add(groupTreeView);
		
		this.elementLayout.setMinSize(this.windowWidth / 4, this.windowHeight);
		this.elementLayout.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		setTreeViewClickListener();
		getJsonDatas();
		initDashBoard();
		
		this.dashboardPane.setColumnHalignment(HPos.LEFT); // align labels on left
		this.dashboardPane.setPrefWrapLength(50); // preferred height = 200

		this.dashboardPane.setMaxSize(this.windowWidth / 3, this.windowHeight - (dashboardMargin * 2));
		this.dashboardPane.setMinSize(this.windowWidth / 3, this.windowHeight - (dashboardMargin * 2));
		this.dashboardPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.contentPane.setColumnHalignment(HPos.LEFT); // align labels on left
		this.contentPane.setPrefWrapLength(50); // preferred height = 200

		this.contentPane.setMaxSize(this.windowWidth / 3, this.windowHeight - (dashboardMargin * 2));
		this.contentPane.setMinSize(this.windowWidth / 3, this.windowHeight - (dashboardMargin * 2));
		this.contentPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		this.window.getChildren().add(this.elementLayout);
		this.window.getChildren().add(this.contentPane);
		this.window.getChildren().add(this.dashboardPane);
	}

	public void initWindowSizeListener(Scene mainScene, StackPane pane) {
		mainScene.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				windowWidth = (double) newSceneWidth;
			}
		});
		mainScene.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight,
					Number newSceneHeight) {
				windowHeight = (double) newSceneHeight;

			}
		});
	}
	
	public void setTreeViewClickListener() {
		projectTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
                TreeItem<String> selectedItem = new_val;
                System.out.println("Selected Text : " + selectedItem.getValue());
                
                displaySelectedProjectContent(selectedItem.getValue(), new_val);
                // do what ever you want
            }
        });
		
		taskTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
                TreeItem<String> selectedItem = new_val;
                System.out.println("Selected Text : " + selectedItem.getValue());
                // do what ever you want
            }
        });
		
		groupTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
                TreeItem<String> selectedItem = new_val;
                System.out.println("Selected Text : " + selectedItem.getValue());
                displaySelectedGroupContent(selectedItem.getValue());
                // do what ever you want
            }
        });
	}
	
	public void updateDashboard() {
		this.dashboardMessageListView.getItems().clear();
		for (Message message : Dashboard.getInstance().getMessages()) {
			this.dashboardMessageListView.getItems().add(message.getMessage());
		}
	}
	
	public void updateProjectTreeView(TreeItem<String> old_val) {
		this.projectItem.getChildren().remove(old_val);
	}
	
	public void updateTaskTreeView() {
		this.taskTreeView.setRoot(null);
		for (Task task : this.tasks) {
			TreeItem<String> newItem = new TreeItem<String>(task.getContent());
			taskItem.getChildren().add(newItem);
		}
	}
	
	public void updateGroupTreeView() {
		this.groupTreeView.setRoot(null);
		for (Group group : this.groups) {
			TreeItem<String> newItem = new TreeItem<String>(group.getName());
			groupItem.getChildren().add(newItem);
		}
	}
	
	public void displaySelectedProjectContent(String projectName, TreeItem<String> old_val) {
		Button delButton = new Button("Supprimer " + projectName);
		int projectIdx;
		
		projectIdx = Helper.getProjectVectorIndex(this.projects, projectName);
		if (projectIdx != -1) {
			delButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
				 
	            @Override
	            public void handle(MouseEvent event) {
	            	Project projectToDel = projects.get(projectIdx);
	            	projectToDel.notifyObserver(new Message("The project " + projectToDel.getName() + " has been deleted."));
	            	updateDashboard();
	                projects.remove(projectIdx);
	                updateProjectTreeView(old_val);
	            }
	        });
			this.contentPane.getChildren().clear();
			this.contentPane.getChildren().add(delButton);
		}
	}
	
	public void displaySelectedGroupContent(String groupName) {
		Group selectedGroup;
		int groupIdx;
		
		this.groupUserListView = new ListView<String>();
		this.groupListViewItem = FXCollections.observableArrayList();		
		
		this.groupUserListView.setMaxSize(this.windowWidth / 3 + (this.dashboardMargin * 3), this.windowHeight - (this.dashboardMargin * 3));
		this.groupUserListView.setMinSize(this.windowWidth / 3 + (this.dashboardMargin * 3), this.windowHeight - (this.dashboardMargin * 3));
		
		this.groupUserListView.setItems(this.groupListViewItem);
		
		groupIdx = Helper.getGroupVectorIndex(this.groups, groupName);
		if (groupIdx != -1) {
			selectedGroup = this.groups.get(groupIdx);
			for (User usr : selectedGroup.getUsers()) {
				this.groupListViewItem.add(usr.getName());
			}
			this.contentPane.getChildren().clear();
			this.contentPane.getChildren().add(new Label(groupName + "'s users :"));
			this.contentPane.getChildren().add(this.groupUserListView);
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponent();
		primaryStage.setTitle("myPenelopeF");
		
		StackPane pane = new StackPane();
        pane.getChildren().add(this.window);
        Scene mainScene = new Scene(pane, windowWidth, windowHeight);
        initWindowSizeListener(mainScene, pane);
        primaryStage.setScene(mainScene);
        primaryStage.show();
	}

}
