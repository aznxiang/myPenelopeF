package main;

import java.util.Vector;

import Elements.Group;
import Elements.Project;
import Elements.Task;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainClass extends Application {

	private double windowWidth;
	private double windowHeight;
	private FlowPane window;
	private FlowPane elementPane;
	private FlowPane dashboardPane;
	private VBox elementLayout;
	private int dashboardMargin;
	
	TreeItem<String> projectItem;
	TreeView<String> project;
	TreeItem<String> taskItem;
	TreeView<String> task;
	TreeItem<String> groupItem;
	TreeView<String> group;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	//TODO
	//change this function when recover by JSON will be implemented
	private void getJsonDatas() {
		Vector<Project> projects = new Vector<Project>();
		projects.add(new Project("toto"));
		projects.add(new Project("tata"));
		projects.add(new Project("tete"));
		projects.add(new Project("titi"));
		projects.add(new Project("tutu"));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(projects.get(i).getName());
			projectItem.getChildren().add(newItem);
		}
		
		Vector<Task> tasks = new Vector<Task>();
		tasks.add(new Task("toto"));
		tasks.add(new Task("tata"));
		tasks.add(new Task("tete"));
		tasks.add(new Task("titi"));
		tasks.add(new Task("tutu"));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(tasks.get(i).getContent());
			taskItem.getChildren().add(newItem);
		}
		
		Vector<Group> groups = new Vector<Group>();
		groups.add(new Group("toto"));
		groups.add(new Group("tata"));
		groups.add(new Group("tete"));
		groups.add(new Group("titi"));
		groups.add(new Group("tutu"));
		for (int i = 0; i < 5; i++) {
			TreeItem<String> newItem = new TreeItem<String>(groups.get(i).getName());
			groupItem.getChildren().add(newItem);
		}
	}
	
	public void initDashBoard() {
		dashboardPane.getChildren().add(new Label("Dashboard"));
		ListView<String> messages = new ListView<String>();
		ObservableList<String> items =FXCollections.observableArrayList ("Single", "Double", "Suite", "Family App");
		messages.setMaxSize((this.windowWidth / 4) * 3, this.windowHeight - (dashboardMargin * 3));
		messages.setMinSize((this.windowWidth / 4) * 3, this.windowHeight - (dashboardMargin * 3));
		messages.setItems(items);
		//dashboardPane.setMargin(messages, new Insets(dashboardMargin, dashboardMargin, dashboardMargin, dashboardMargin));
		dashboardPane.getChildren().add(messages);
	}
	
	public void initComponent() {
		this.window = new FlowPane(Orientation.HORIZONTAL);
		this.elementLayout = new VBox();
		this.elementPane = new FlowPane(Orientation.VERTICAL);
		this.dashboardPane = new FlowPane(Orientation.VERTICAL);
		
		
		this.windowWidth = 600;
		this.windowHeight = 400;
		this.dashboardMargin = 20;
		this.elementPane.setColumnHalignment(HPos.LEFT); // align labels on left
		this.elementPane.setPrefWrapLength(50); // preferred height = 200
		projectItem = new TreeItem<String>("Project");
		project = new TreeView<String>(projectItem);
		taskItem = new TreeItem<String>("Tasks");
		task = new TreeView<String>(taskItem);
		groupItem = new TreeItem<String>("Group");
		group = new TreeView<String>(groupItem);
		
		project.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		task.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		group.setMaxSize(this.windowWidth / 4, this.windowHeight / 3);
		this.elementLayout.getChildren().add(project);
		this.elementLayout.getChildren().add(task);
		this.elementLayout.getChildren().add(group);

		getJsonDatas();
		this.elementLayout.setMinSize(this.windowWidth / 4, this.windowHeight);
		this.elementLayout.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		initDashBoard();
		
		this.dashboardPane.setColumnHalignment(HPos.LEFT); // align labels on left
		this.dashboardPane.setPrefWrapLength(50); // preferred height = 200

		this.dashboardPane.setMaxSize((this.windowWidth / 4) * 3, this.windowHeight - (dashboardMargin * 2));
		this.dashboardPane.setMinSize((this.windowWidth / 4) * 3, this.windowHeight - (dashboardMargin * 2));
		this.dashboardPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

		this.window.getChildren().add(this.elementLayout);
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
