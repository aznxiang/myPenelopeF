package GraphicUserInterface;

import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
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
	private TextField projectNameTF;
	private TextField taskProjectNameTF;
	private TextField taskContentTF;
	private TextField groupNameTF;
	private TextField groupUsersTF;
	private Button addProjectBtn;
	private Button addTaskBtn;
	private Button addGroupBtn;
	
	private Vector<Project> projects;
	private Vector<Group> groups;
	
	private ListView<String> groupUserListView;
	private ObservableList<String> groupListViewItem;
	
	private ListView<String> projectTasksListView;
	private ObservableList<String> projectTasksListViewItem;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//TODO
	//change this function when recover by JSON will be implemented
	private void getJsonDatas() {
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
		Group g = new Group("titi", users, Dashboard.getInstance());
		Group g1 = new Group("tede", users2, Dashboard.getInstance());
		Group g2 = new Group("tudu", users, Dashboard.getInstance());
		Group g3 = new Group("tol", users2, Dashboard.getInstance());
		Group g4 = new Group("totzedezdo", users, Dashboard.getInstance());
		Vector<Group> vGrp = new Vector<Group>();
		vGrp.add(g);
		vGrp.add(g1);
		vGrp.add(g2);
		//vGrp.add(g3);
		//vGrp.add(g4);
		this.groups.add(g);
		this.groups.add(g1);
		this.groups.add(g2);
		this.groups.add(g3);
		this.groups.add(g4);
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(groups.get(i).getName());
			this.groupItem.getChildren().add(newItem);
		}
		
		Vector<Task> vTasks = new Vector<Task>();
		vTasks.add(new Task("toto", "implzrzrement graphic vxcvcwxvxcbuttonefzed to toto Activity", "onlyonewhocansendmessageandit'snormal;)"));
		vTasks.add(new Task("toto", "implzrzed to toto Activity", "onlyonewhocansendmessageandit'snormal;)"));
		vTasks.add(new Task("toto", " to toto Activity", "onlyonewhocansendmessageandit'snormal;)"));
		vTasks.add(new Task("toto", "implzrzrement grvcwxvxcbuttono toto Activity", "onlyonewhocansendmessageandit'snormal;)"));
		vTasks.add(new Task("toto", "implzrzrcvcwxvxcbuttonefzed to toto Activity", "onlyonewhocansendmessageandit'snormal;)"));
		
		Project p = new Project("test", vTasks, vGrp, Dashboard.getInstance());
		
		Project p1 = new Project("onlyonewhocansendmessageandit'snormal;)", vTasks, vGrp, Dashboard.getInstance());
		Project p2 = new Project("onlyonewhocansendmessageandit'snormal;)", vTasks, vGrp, Dashboard.getInstance());
		Project p3 = new Project("onlyonewhocansendmessageandit'snormal;)", vTasks, vGrp, Dashboard.getInstance());
		Project p4 = new Project("onlyonewhocansendmessageandit'snormal;)", vTasks, vGrp, Dashboard.getInstance());
		
		this.projects = new Vector<Project>();
		this.projects.add(p);
		this.projects.add(p1);
		this.projects.add(p2);
		this.projects.add(p3);
		this.projects.add(p4);
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(projects.get(i).getName());
			this.projectItem.getChildren().add(newItem);
		}

		for (Project project : this.projects) {
			TreeItem<String> newItem = new TreeItem<String>(project.getName());
			this.taskItem.getChildren().add(newItem);
		}
	}
	
	public void initCreationArea() {
		this.addProjectBtn = new Button("Add project");
		this.addTaskBtn = new Button("Add Task");
		this.addGroupBtn = new Button("Add Group");
		
		addProjectBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
            @Override
            public void handle(MouseEvent event) {
            	if (projectNameTF.getText() != null) {
            		projects.add(new Project(projectNameTF.getText(), Dashboard.getInstance()));
            		addProjectTreeViewItem(projectNameTF.getText());
            		projects.get(Helper.getProjectVectorIndex(projects, projectNameTF.getText())).notifyObserver(
            				new Message("Project " + projectNameTF.getText() + " has been created !"));
            		updateDashboard();
            	}
            }
        });
		addTaskBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
            @Override
            public void handle(MouseEvent event) {
            	if (taskProjectNameTF.getText() != null && taskContentTF.getText() != null) {
            		int projectIdx = Helper.getProjectVectorIndex(projects, taskProjectNameTF.getText());
            		if (projectIdx != -1) {
            			Task createdTask = new Task("", taskContentTF.getText(), taskProjectNameTF.getText());
            			projects.get(projectIdx).addTask(createdTask);
            			projects.get(projectIdx).notifyObserver(new Message("Task :" + createdTask.getContent() + " has been added to Project :" + projects.get(projectIdx).getName()));
            			updateDashboard();
            			projectTasksListViewItem.add(createdTask.getContent());
            			projectTasksListView.refresh();
            		}
            	}
            }
        });
		addGroupBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
			 
            @Override
            public void handle(MouseEvent event) {
            	if (groupNameTF.getText() != null) {
            		groups.add(new Group(groupNameTF.getText(), Dashboard.getInstance()));
            		Group groupAdded = groups.get(Helper.getGroupVectorIndex(groups, groupNameTF.getText()));
            		groupItem.getChildren().add(new TreeItem<String>(groupAdded.getName()));
            		groupAdded.notifyObserver(new Message("Group " + groupAdded.getName() + " has been created !"));
            		updateDashboard();
            		displaySelectedGroupContent(groupAdded.getName());
            	}
            }
        });
		
		this.projectNameTF.setMaxSize(dashboardMargin * 8, 30);
		this.projectNameTF.setMinSize(dashboardMargin * 8, 30);
		this.taskProjectNameTF.setMaxSize(dashboardMargin * 8, 30);
		this.taskProjectNameTF.setMinSize(dashboardMargin * 8, 30);
		this.taskContentTF.setMaxSize(dashboardMargin * 8, 30);
		this.taskContentTF.setMinSize(dashboardMargin * 8, 30);
		this.groupNameTF.setMaxSize(dashboardMargin * 8, 30);
		this.groupNameTF.setMinSize(dashboardMargin * 8, 30);
		this.groupUsersTF.setMaxSize(dashboardMargin * 8, 30);
		this.groupUsersTF.setMinSize(dashboardMargin * 8, 30);
		
		this.dashboardPane.getChildren().add(new Label("Project's name:"));
		this.dashboardPane.getChildren().add(projectNameTF);
		this.dashboardPane.getChildren().add(this.addProjectBtn);
		this.dashboardPane.getChildren().add(new Label("Task's project name:"));
		this.dashboardPane.getChildren().add(this.taskProjectNameTF);
		this.dashboardPane.getChildren().add(new Label("Task's content :"));
		this.dashboardPane.getChildren().add(this.taskContentTF);
		this.dashboardPane.getChildren().add(this.addTaskBtn);
		this.dashboardPane.getChildren().add(new Label("Group's name :"));
		this.dashboardPane.getChildren().add(this.groupNameTF);
		this.dashboardPane.getChildren().add(this.addGroupBtn);
	}
	
	public void initDashBoard() {
		this.dashboardPane.getChildren().add(new Label("DASHBOARD"));
		
		this.dashboardMessageListView = new ListView<String>();
		this.listViewitems = FXCollections.observableArrayList();		
		
		this.dashboardMessageListView.setMaxSize(this.windowWidth / 3 - this.dashboardMargin, this.windowHeight - (this.dashboardMargin * 3));
		this.dashboardMessageListView.setMinSize(this.windowWidth / 3 - this.dashboardMargin, this.windowHeight - (this.dashboardMargin * 3));
		this.dashboardMessageListView.setItems(this.listViewitems);
		
		this.dashboardPane.getChildren().add(this.dashboardMessageListView);
		initCreationArea();
	}
	
	public void initComponent() {
		this.window = new FlowPane(Orientation.HORIZONTAL);
		this.elementLayout = new VBox();
		this.contentPane = new FlowPane(Orientation.VERTICAL);
		this.dashboardPane = new FlowPane(Orientation.VERTICAL);
		
		
		this.windowWidth = 1500;
		this.windowHeight = 900;
		this.window.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.dashboardMargin = 18;
		this.projectItem = new TreeItem<String>("Project");
		this.projectTreeView = new TreeView<String>(projectItem);
		this.taskItem = new TreeItem<String>("Tasks");
		this.taskTreeView = new TreeView<String>(taskItem);
		this.groupItem = new TreeItem<String>("Group");
		this.groupTreeView = new TreeView<String>(groupItem);
		this.projectNameTF = new TextField();
		this.taskProjectNameTF = new TextField();
		this.taskContentTF = new TextField();
		this.groupNameTF = new TextField();
		this.groupUsersTF = new TextField();
		
		
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

		this.dashboardPane.setMaxSize(this.windowWidth / 3 + (this.dashboardMargin * 7), this.windowHeight - (this.dashboardMargin * 2));
		this.dashboardPane.setMinSize(this.windowWidth / 3 + (this.dashboardMargin * 7), this.windowHeight - (this.dashboardMargin * 2));
		this.dashboardPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.contentPane.setColumnHalignment(HPos.LEFT); // align labels on left
		this.contentPane.setPrefWrapLength(50); // preferred height = 200

		this.contentPane.setMaxSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 2));
		this.contentPane.setMinSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 2));
		this.contentPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		this.window.getChildren().add(this.elementLayout);
		this.window.getChildren().add(this.contentPane);
		this.window.getChildren().add(this.dashboardPane);
	}
	
	public void setTreeViewClickListener() {
		projectTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
                displaySelectedProjectContent(new_val);
            }
        });
		
		taskTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
            	displaySelectedProjectTasks(new_val);
            }
        });
		
		groupTreeView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val) {
                displaySelectedGroupContent(new_val.getValue());
            }
        });
	}
	
	public void updateDashboard() {
		this.dashboardMessageListView.getItems().clear();
		for (Message message : Dashboard.getInstance().getMessages()) {
			this.dashboardMessageListView.getItems().add(message.getMessage());
		}
	}
	
	public void removeProjectTreeViewItem(TreeItem<String> old_val) {
		this.projectItem.getChildren().remove(old_val);
	}
	
	public void addProjectTreeViewItem(String projectName) {
		this.projectItem.getChildren().add(new TreeItem<String>(projectName));
	}
	
	public void updateTaskTreeView(Project projectToDel) {
		for (int i = 0; i < this.taskItem.getChildren().size(); i++) {
			if (this.taskItem.getChildren().get(i).getValue() == projectToDel.getName()) {
				this.taskItem.getChildren().remove(i);
			}
		}
	}
	
	public void updateGroupTreeView() {
		this.groupTreeView.setRoot(null);
		for (Group group : this.groups) {
			TreeItem<String> newItem = new TreeItem<String>(group.getName());
			groupItem.getChildren().add(newItem);
		}
	}
	
	public void displaySelectedProjectContent(TreeItem<String> new_val) {
		Button delButton = new Button("Supprimer " + new_val.getValue());
		int projectIdx;
		
		projectIdx = Helper.getProjectVectorIndex(this.projects, new_val.getValue());
		if (projectIdx != -1) {
			Project project = projects.get(projectIdx);
			ListView<String> usersLV = new ListView<String>();
			ObservableList<String> userLVItems= FXCollections.observableArrayList();
			delButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
				 
	            @Override
	            public void handle(MouseEvent event) {
	            	project.notifyObserver(new Message("The project " + project.getName() + " has been deleted."));
	            	updateDashboard();
	                projects.remove(projectIdx);
	                removeProjectTreeViewItem(new_val);
	                updateTaskTreeView(project);
	            }
	        });
			this.contentPane.getChildren().clear();
			this.contentPane.getChildren().add(delButton);
			if (this.projects.get(projectIdx).getGroups() != null) {
				Label projectGroups = new Label("Project " + this.projects.get(projectIdx).getName() + "'s user groups");
				usersLV.setMaxSize(this.windowWidth / 3 - (dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 10));
				usersLV.setMinSize(this.windowWidth / 3 - (dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 10));
				usersLV.setItems(userLVItems);
				for (Group group : this.projects.get(projectIdx).getGroups()) {
					userLVItems.add("°Group : " + group.getName() + "°");
					for (User user : group.getUsers()) {
						userLVItems.add(user.getName());
					}
				}
				this.contentPane.getChildren().add(projectGroups);
				this.contentPane.getChildren().add(usersLV);
			}
			this.contentPane.getChildren().add(new Label("Group's name :"));
			Button addGroupToProject = new Button("Add Group");
			TextField groupName = new TextField();
			addGroupToProject.setOnMouseClicked(new EventHandler<MouseEvent>(){
				 
	            @Override
	            public void handle(MouseEvent event) {
	            	if (groupName.getText() != null) {
	            		Group addedGroup = groups.get(Helper.getGroupVectorIndex(groups, groupName.getText()));
	            		project.getGroups().add(addedGroup);
	            		userLVItems.add("°Group : " + addedGroup.getName() + "°");
	            		for (User user : addedGroup.getUsers()) {
	            			userLVItems.add(user.getName());
	            		}
	            		project.notifyObserver(new Message("Group " + addedGroup.getName() + " has been added to " + project.getName()));
	            		updateDashboard();
	            	}
	            }
	        });
			groupName.setMaxSize(this.windowWidth / 3 - (this.dashboardMargin * 2), 30);
			groupName.setMinSize(this.windowWidth / 3 - (this.dashboardMargin * 2), 30);
			this.contentPane.getChildren().add(groupName);
			this.contentPane.getChildren().add(addGroupToProject);
		}
	}
	
	public void displaySelectedProjectTasks(TreeItem<String> new_val) {
		int projectIdx = Helper.getProjectVectorIndex(this.projects, new_val.getValue());
		System.out.println("projectidx " + projectIdx);
		if (projectIdx != -1) {
			
			this.projectTasksListView = new ListView<String>();
			this.projectTasksListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

		        @Override
		        public void handle(MouseEvent event) {
					if (projectTasksListView.getSelectionModel().getSelectedItem() != null) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Delete task");
						alert.setContentText( "Do you want to delete this task?" + projectTasksListView.getSelectionModel().getSelectedItem());

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							Project project = projects.get(projectIdx);
							project.getTasks().remove(Helper.getTaskVectorIndex(project.getTasks(),
									projectTasksListView.getSelectionModel().getSelectedItem()));
							project.notifyObserver(new Message("Task :" + projectTasksListView.getSelectionModel().getSelectedItem()
											+ " from Project :" + project.getName() + " has been deleted."));
							updateDashboard();
							displaySelectedProjectTasks(new_val);
						} else {
						}
					}
		        }
		    });
			this.projectTasksListViewItem = FXCollections.observableArrayList();		
			this.projectTasksListView.setMaxSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 3));
			this.projectTasksListView.setMinSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 3));
			this.projectTasksListView.setItems(this.projectTasksListViewItem);
			for (Task task : this.projects.get(projectIdx).getTasks()) {
				this.projectTasksListViewItem.add(task.getContent());
			}
			this.contentPane.getChildren().clear();
			this.contentPane.getChildren().add(new Label(new_val.getValue() + "'s current tasks :"));
			this.contentPane.getChildren().add(this.projectTasksListView);
		}
	}
	
	public void displaySelectedGroupContent(String groupName) {
		int groupIdx;
		
		groupIdx = Helper.getGroupVectorIndex(this.groups, groupName);
		if (groupIdx != -1) {
			if (groups.get(groupIdx).getUsers() != null) {
				this.groupUserListView = new ListView<String>();
				this.groupListViewItem = FXCollections.observableArrayList();
				this.groupUserListView.setMaxSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 7));
				this.groupUserListView.setMinSize(this.windowWidth / 3 - (this.dashboardMargin * 2), this.windowHeight - (this.dashboardMargin * 7));
				this.groupUserListView.setItems(this.groupListViewItem);
				for (User usr : this.groups.get(groupIdx).getUsers()) {
					this.groupListViewItem.add(usr.getName());
				}
			}
			this.contentPane.getChildren().clear();
			this.contentPane.getChildren().add(new Label(groupName + "'s users :"));
			if (groups.get(groupIdx).getUsers() != null) {
				this.contentPane.getChildren().add(this.groupUserListView);
			}
			
			TextField usersToAdd = new TextField();
			Button addUser = new Button("Add user");
			
			addUser.setOnMouseClicked(new EventHandler<MouseEvent>(){
				 
	            @Override
	            public void handle(MouseEvent event) {
	            	if (usersToAdd.getText() != null) {
	            		String[] allUsersToAdd = usersToAdd.getText().split(";");
	            		for(int i = 0 ; i < allUsersToAdd.length ; i++)
	            		{
	            			User user = new User(allUsersToAdd[i]);
	            			groups.get(groupIdx).addUser(user);
	            			groups.get(groupIdx).notifyObserver(new Message("User " + user.getName() + " has been added to " + groups.get(groupIdx).getName()));
	            		}
	            		updateDashboard();
	            		displaySelectedGroupContent(groupName);
	            	}
	            }
	        });
			usersToAdd.setMaxSize(this.windowWidth / 3 - (this.dashboardMargin * 2), 30);
			usersToAdd.setMinSize(this.windowWidth / 3 - (this.dashboardMargin * 2), 30);
			this.contentPane.getChildren().add(new Label("User to add to " + groupName + " (seprated by \";\") :"));
			this.contentPane.getChildren().add(usersToAdd);
			this.contentPane.getChildren().add(addUser);
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponent();
		primaryStage.setTitle("myPenelopeF");
		
		StackPane pane = new StackPane();
        pane.getChildren().add(this.window);
        Scene mainScene = new Scene(pane, windowWidth, windowHeight);
        primaryStage.setScene(mainScene);
        primaryStage.show();
	}

}
