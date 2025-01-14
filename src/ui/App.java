package ui;

import actor.Bus;
import actor.Dashboard;
import actor.Manager;
import blockchain.Block;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import actor.Bus;
import actor.Station;
import actor.Dashboard;
import org.json.simple.JSONObject;

public class App extends Application {
    public VBox layout;
    public VBox vBoxBC;
    public VBox vboxBlocs;
    public ScrollPane scrollPane;
    public Label label1;
    public Label labelBus1;
    public Label labelBus2;
    public Label labelBus3;
    public Label labelDelayBus1;
    public Label labelDelayBus2;
    public Label labelDelayBus3;
    public Label labelPosBus1;
    public Label labelPosBus2;
    public Label labelPosBus3;
    public Label Bus1Auth;
    public Label Bus2Auth;
    public Label Bus3Auth;
    public Label StationsBabAuth;
    public Label StationsBachAuth;
    public Label StationsDarAuth;
    public Label StationsHarrachAuth;
    public Label StationsHammediAuth;
    public HBox hbox1;
    public HBox hBoxBuses;
    public HBox hBoxDelayBuses;
    public HBox hBoxPosBuses;
    public Button buttonAuth;

    public ImageView view_c1 ;
    public ImageView view_c2;
    public ImageView view_c3;
    public ImageView view_c4;
    public ImageView view_c5;
    public ImageView view_c6;
    public ImageView view_c7;
    public ImageView view_c8;

    public TableView<List<StringProperty>> table;
    public TableColumn<List<StringProperty>, String> BusCol;
    public TableColumn<List<StringProperty>, String> StationCol;
    public TableColumn<List<StringProperty>, String> TimeCol;
    public TableColumn<List<StringProperty>, String> TypeCol;
    public TableColumn<List<StringProperty>, String> Position;
    public TableColumn<List<StringProperty>, String> HashCol;
    public TableColumn<List<StringProperty>, String> PrHashCol;
    public TableColumn<List<StringProperty>, String> BlockCol;

    public ScatterChart<Number,Number> sc;
    public ScatterChart<Number,Number> sc_2;
    public ScatterChart<Number,Number> sc_3;

    public XYChart.Series series;
    public XYChart.Series series2;
    public XYChart.Series series3;

    public XYChart.Series series_2;
    public XYChart.Series series2_2;
    public XYChart.Series series3_2;

    public XYChart.Series series_3;
    public XYChart.Series series2_3;
    public XYChart.Series series3_3;

    public XYChart.Data S1;
    public XYChart.Data S5;
    public XYChart.Data d9;
    public XYChart.Data d10;
    public XYChart.Data d11;
    public XYChart.Data d1;
    public XYChart.Data d2;
    public XYChart.Data S2;
    public XYChart.Data d3;
    public XYChart.Data d4;
    public XYChart.Data d5;
    public XYChart.Data S3;
    public XYChart.Data d6;
    public XYChart.Data S4;
    public XYChart.Data d7;
    public XYChart.Data d8;

    public XYChart.Data S1_2;
    public XYChart.Data S5_2;
    public XYChart.Data d9_2;
    public XYChart.Data d10_2;
    public XYChart.Data d11_2;
    public XYChart.Data d1_2;
    public XYChart.Data d2_2;
    public XYChart.Data S2_2;
    public XYChart.Data d3_2;
    public XYChart.Data d4_2;
    public XYChart.Data d5_2;
    public XYChart.Data S3_2;
    public XYChart.Data d6_2;
    public XYChart.Data S4_2;
    public XYChart.Data d7_2;
    public XYChart.Data d8_2;

    public XYChart.Data S1_3;
    public XYChart.Data S5_3;
    public XYChart.Data d9_3;
    public XYChart.Data d10_3;
    public XYChart.Data d11_3;
    public XYChart.Data d1_3;
    public XYChart.Data d2_3;
    public XYChart.Data S2_3;
    public XYChart.Data d3_3;
    public XYChart.Data d4_3;
    public XYChart.Data d5_3;
    public XYChart.Data S3_3;
    public XYChart.Data d6_3;
    public XYChart.Data S4_3;
    public XYChart.Data d7_3;
    public XYChart.Data d8_3;

    public static App instance;

    public static Manager manager;
    public static Thread threadManager;

    @Override
    public void start(Stage stage) throws IOException {

        vBoxBC = new VBox();
        vBoxBC.setAlignment(Pos.CENTER_LEFT);
        vBoxBC.setSpacing(10);
        vBoxBC.setStyle("-fx-background-color: #889EAF;");
        vBoxBC.setMinWidth(320);
        //vBoxBC.setMaxWidth(320);


        Label lb = new Label("Blocks");
        lb.setFont(new Font("Segoe UI Semibold", 20));
        lb.setTextFill(Color.web("#000000"));
        Image img = new Image("ui/images/blockchain (3).png");
        ImageView view = new ImageView(img);
        view.setPreserveRatio(true);
        lb.setGraphic(view);

        HBox hb = new HBox(lb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(100);
        hb.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        table = new TableView<List<StringProperty>>();
        //table.setPrefSize( 300, 700 );
        table.setPrefHeight(610);

        BusCol = new TableColumn("Bus");
        BusCol.setPrefWidth(40);
        BusCol.setCellValueFactory(data -> data.getValue().get(0));

        StationCol = new TableColumn("Station");
        StationCol.setPrefWidth(90);
        StationCol.setCellValueFactory(data -> data.getValue().get(1));

        TimeCol = new TableColumn("Time");
        TimeCol.setPrefWidth(55);
        TimeCol.setCellValueFactory(data -> data.getValue().get(2));

        TypeCol = new TableColumn("Event Type");
        TypeCol.setPrefWidth(95);
        TypeCol.setCellValueFactory(data -> data.getValue().get(3));

        Position = new TableColumn("Position");
        Position.setPrefWidth(70);
        Position.setCellValueFactory(data -> data.getValue().get(4));

        HashCol = new TableColumn("Hash");
        HashCol.setPrefWidth(70);
        HashCol.setCellValueFactory(data -> data.getValue().get(5));

        PrHashCol = new TableColumn("Previous Hash");
        PrHashCol.setPrefWidth(100);
        PrHashCol.setCellValueFactory(data -> data.getValue().get(6));

        BlockCol = new TableColumn("N° Bloc");
        BlockCol.setPrefWidth(50);
        BlockCol.setCellValueFactory(data -> data.getValue().get(7));

        table.getColumns().addAll(BlockCol,HashCol,PrHashCol,BusCol,StationCol,TimeCol,TypeCol,Position);

        vboxBlocs = new VBox(hb,table);
        vboxBlocs.setAlignment(Pos.TOP_CENTER);
        vboxBlocs.setSpacing(5);



        labelBus1 = new Label("Bus1");
        labelBus2 = new Label("Bus2");
        labelBus3 = new Label("Bus3");

        labelBus1.setPadding(new Insets(20));
        labelBus1.setFont(new Font("Segoe UI Light", 14));
        labelBus1.setTextFill(Color.web("#000000"));

        labelBus2.setPadding(new Insets(20));
        labelBus2.setFont(new Font("Segoe UI Light", 14));
        labelBus2.setTextFill(Color.web("#000000"));

        labelBus3.setPadding(new Insets(20));
        labelBus3.setFont(new Font("Segoe UI Light", 14));
        labelBus3.setTextFill(Color.web("#000000"));

        hBoxBuses = new HBox(labelBus1, labelBus2, labelBus3);
        hBoxBuses.setAlignment(Pos.CENTER);
        hBoxBuses.setSpacing(100);

        labelDelayBus1 = new Label("");
        labelDelayBus1.setFont(new Font("Segoe UI Semibold", 14));
        labelDelayBus1.setTextFill(Color.web("#F90716"));

        labelDelayBus2 = new Label("");
        labelDelayBus2.setFont(new Font("Segoe UI Semibold", 14));
        labelDelayBus2.setTextFill(Color.web("#F90716"));

        labelDelayBus3 = new Label("");
        labelDelayBus3.setFont(new Font("Segoe UI Semibold", 14));
        labelDelayBus3.setTextFill(Color.web("#F90716"));

        hBoxDelayBuses = new HBox(labelDelayBus1, labelDelayBus2, labelDelayBus3);
        hBoxDelayBuses.setAlignment(Pos.CENTER);
        hBoxDelayBuses.setSpacing(100);

        labelPosBus1 = new Label("PosBus1");
        labelPosBus2 = new Label("PosBus2");
        labelPosBus3 = new Label("PosBus3");

        label1 = new Label("Bus Stations Management");
        label1.setFont(new Font("Segoe UI Semibold", 26));
        label1.setTextFill(Color.web("#000000"));
        Image img1 = new Image("ui/images/bus-stop-pointer (1).png");
        ImageView view1 = new ImageView(img1);
        view1.setPreserveRatio(true);
        label1.setGraphic(view1);

        hbox1 = new HBox(label1);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");
        hbox1.setMinHeight(40);
        hbox1.setPadding(new Insets(7, 5, 7, 5));
        BorderPane root = new BorderPane();
        root.setTop(hbox1);
        root.setMargin(hbox1, new Insets(5,5,2,5));


        final NumberAxis xAxis = new NumberAxis(0, 12, 1);
        final NumberAxis yAxis = new NumberAxis(0, 10, 1);

        final NumberAxis xAxis2 = new NumberAxis(0, 12, 1);
        final NumberAxis yAxis2 = new NumberAxis(0, 10, 1);

        final NumberAxis xAxis3 = new NumberAxis(0, 12, 1);
        final NumberAxis yAxis3 = new NumberAxis(0, 10, 1);

        sc = new ScatterChart<>(xAxis,yAxis);
        sc.setPrefSize(420, 250);
        sc.setMinSize(420, 200);
        sc.setMaxSize(420, 200);
        sc.setLegendVisible(false);

        sc_2 = new ScatterChart<>(xAxis2,yAxis2);
        sc_2.setPrefSize(420, 200);
        sc_2.setMinSize(420, 200);
        sc_2.setMaxSize(420, 200);
        sc_2.setLegendVisible(false);

        sc_3 = new ScatterChart<>(xAxis3,yAxis3);
        sc_3.setPrefSize(420, 200);
        sc_3.setMinSize(420, 200);
        sc_3.setMaxSize(420, 200);
        sc_3.setLegendVisible(false);

        series = new XYChart.Series();
        series2= new XYChart.Series();
        series3= new XYChart.Series();

        series_2 = new XYChart.Series();
        series2_2= new XYChart.Series();
        series3_2= new XYChart.Series();

        series_3 = new XYChart.Series();
        series2_3= new XYChart.Series();
        series3_3= new XYChart.Series();

        S1 = new  XYChart.Data(2,2);
        S5 = new XYChart.Data(5, 8);
        d9 = new XYChart.Data(4, 8);
        d10 = new XYChart.Data(4, 3);
        d11 = new XYChart.Data(2, 3);
        d1 = new XYChart.Data(6, 2);
        d2 = new XYChart.Data(6, 4);
        S2 = new XYChart.Data(8, 4);
        d3 = new XYChart.Data(9, 4);
        d4 = new XYChart.Data(9, 5);
        d5 = new XYChart.Data(11, 5);
        S3 = new XYChart.Data(11, 7);
        d6 = new XYChart.Data(11, 9);
        S4 = new XYChart.Data(9, 9);
        d7 = new XYChart.Data(7, 9);
        d8 = new XYChart.Data(7, 8);

        S1_2 = new  XYChart.Data(2,2);
        S5_2 = new XYChart.Data(5, 8);
        d9_2 = new XYChart.Data(4, 8);
        d10_2 = new XYChart.Data(4, 3);
        d11_2 = new XYChart.Data(2, 3);
        d1_2 = new XYChart.Data(6, 2);
        d2_2 = new XYChart.Data(6, 4);
        S2_2 = new XYChart.Data(8, 4);
        d3_2 = new XYChart.Data(9, 4);
        d4_2 = new XYChart.Data(9, 5);
        d5_2 = new XYChart.Data(11, 5);
        S3_2 = new XYChart.Data(11, 7);
        d6_2 = new XYChart.Data(11, 9);
        S4_2 = new XYChart.Data(9, 9);
        d7_2 = new XYChart.Data(7, 9);
        d8_2 = new XYChart.Data(7, 8);

        S1_3 = new  XYChart.Data(2,2);
        S5_3 = new XYChart.Data(5, 8);
        d9_3 = new XYChart.Data(4, 8);
        d10_3 = new XYChart.Data(4, 3);
        d11_3 = new XYChart.Data(2, 3);
        d1_3 = new XYChart.Data(6, 2);
        d2_3 = new XYChart.Data(6, 4);
        S2_3 = new XYChart.Data(8, 4);
        d3_3 = new XYChart.Data(9, 4);
        d4_3 = new XYChart.Data(9, 5);
        d5_3 = new XYChart.Data(11, 5);
        S3_3 = new XYChart.Data(11, 7);
        d6_3 = new XYChart.Data(11, 9);
        S4_3 = new XYChart.Data(9, 9);
        d7_3 = new XYChart.Data(7, 9);
        d8_3 = new XYChart.Data(7, 8);


        sc.getData().add(series2); //d
        sc.getData().add(series3); //station
        sc.getData().add(series);  //bus

        sc_2.getData().add(series2_2); //d
        sc_2.getData().add(series3_2); //station
        sc_2.getData().add(series_2);  //bus

        sc_3.getData().add(series2_3); //d
        sc_3.getData().add(series3_3); //station
        sc_3.getData().add(series_3);  //bus

        NumberAxis xAxisL = new NumberAxis(0, 12, 1);
        NumberAxis yAxisL = new NumberAxis(0, 10, 1);
        final LineChart<Number,Number> linchart = new LineChart<>(xAxisL,yAxisL);
        linchart.setOpacity(0.3);
        linchart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        linchart.setLegendVisible(false);


        XYChart.Series serieL1 = new XYChart.Series();
        serieL1.getData().add(new XYChart.Data(2,2));
        serieL1.getData().add(new XYChart.Data(6,2));
        serieL1.getData().add(new XYChart.Data(6,4));
        serieL1.getData().add(new XYChart.Data(9,4));
        serieL1.getData().add(new XYChart.Data(9,5));
        serieL1.getData().add(new XYChart.Data(11,5));
        serieL1.getData().add(new XYChart.Data(11,9));

        XYChart.Series serieL2 = new XYChart.Series();
        serieL2.getData().add(new XYChart.Data(2,2));
        serieL2.getData().add(new XYChart.Data(2,3));
        serieL2.getData().add(new XYChart.Data(4,3));
        serieL2.getData().add(new XYChart.Data(4,8));
        serieL2.getData().add(new XYChart.Data(7,8));
        serieL2.getData().add(new XYChart.Data(7,9));
        serieL2.getData().add(new XYChart.Data(11,9));

        linchart.setAnimated(false);
        linchart.setCreateSymbols(false);
        linchart.getData().addAll(serieL1, serieL2);

        NumberAxis xAxisL22 = new NumberAxis(0, 12, 1);
        NumberAxis yAxisL22 = new NumberAxis(0, 10, 1);
        final LineChart<Number,Number> linchart2 = new LineChart<>(xAxisL22,new NumberAxis(0, 10, 1));
        linchart2.setOpacity(0.3);
        linchart2.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        linchart2.setLegendVisible(false);


        XYChart.Series serieL12 = new XYChart.Series();
        serieL12.getData().add(new XYChart.Data(2,2));
        serieL12.getData().add(new XYChart.Data(6,2));
        serieL12.getData().add(new XYChart.Data(6,4));
        serieL12.getData().add(new XYChart.Data(9,4));
        serieL12.getData().add(new XYChart.Data(9,5));
        serieL12.getData().add(new XYChart.Data(11,5));
        serieL12.getData().add(new XYChart.Data(11,9));

        XYChart.Series serieL22 = new XYChart.Series();
        serieL22.getData().add(new XYChart.Data(2,2));
        serieL22.getData().add(new XYChart.Data(2,3));
        serieL22.getData().add(new XYChart.Data(4,3));
        serieL22.getData().add(new XYChart.Data(4,8));
        serieL22.getData().add(new XYChart.Data(7,8));
        serieL22.getData().add(new XYChart.Data(7,9));
        serieL22.getData().add(new XYChart.Data(11,9));

        linchart2.setAnimated(false);
        linchart2.setCreateSymbols(false);
        linchart2.getData().addAll(serieL12, serieL22);

        NumberAxis xAxisL23 = new NumberAxis(0, 12, 1);
        NumberAxis yAxisL23 = new NumberAxis(0, 10, 1);
        final LineChart<Number,Number> linchart3 = new LineChart<>(xAxisL23,yAxisL23);
        linchart3.setOpacity(0.3);
        linchart3.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        linchart3.setLegendVisible(false);


        XYChart.Series serieL13 = new XYChart.Series();
        serieL13.getData().add(new XYChart.Data(2,2,new Label("Bab")));
        serieL13.getData().add(new XYChart.Data(6,2));
        serieL13.getData().add(new XYChart.Data(6,4));
        serieL13.getData().add(new XYChart.Data(9,4));
        serieL13.getData().add(new XYChart.Data(9,5));
        serieL13.getData().add(new XYChart.Data(11,5));
        serieL13.getData().add(new XYChart.Data(11,9));

        XYChart.Series serieL23 = new XYChart.Series();
        serieL23.getData().add(new XYChart.Data(2,2));
        serieL23.getData().add(new XYChart.Data(2,3));
        serieL23.getData().add(new XYChart.Data(4,3));
        serieL23.getData().add(new XYChart.Data(4,8));
        serieL23.getData().add(new XYChart.Data(7,8));
        serieL23.getData().add(new XYChart.Data(7,9));
        serieL23.getData().add(new XYChart.Data(11,9));

        linchart3.setAnimated(false);
        linchart3.setCreateSymbols(false);
        linchart3.getData().addAll(serieL13, serieL23);

        StackPane pane=new StackPane();
        pane.getChildren().add(linchart);
        pane.getChildren().add(sc);
        pane.setPrefSize(420, 250);
        pane.setMinSize(420, 200);
        pane.setMaxSize(420, 200);
        pane.setAlignment(Pos.TOP_LEFT);

        StackPane pane2=new StackPane();
        pane2.getChildren().add(linchart2);
        pane2.getChildren().add(sc_2);
        pane2.setPrefSize(420, 250);
        pane2.setMinSize(420, 200);
        pane2.setMaxSize(420, 200);
        pane2.setAlignment(Pos.TOP_LEFT);

        StackPane pane3=new StackPane();
        pane3.getChildren().add(linchart3);
        pane3.getChildren().add(sc_3);
        pane3.setPrefSize(420, 250);
        pane3.setMinSize(420, 200);
        pane3.setMaxSize(420, 200);
        pane3.setAlignment(Pos.TOP_LEFT);


        Label lbus1= new Label("Bus 1");
        lbus1.setFont(new Font("Segoe UI Semibold", 20));
        lbus1.setTextFill(Color.web("#000000"));
        lbus1.setPadding(new Insets(10));

        Label lbus2= new Label("Bus 2");
        lbus2.setFont(new Font("Segoe UI Semibold", 20));
        lbus2.setTextFill(Color.web("#000000"));
        lbus2.setPadding(new Insets(10));

        Label lbus3= new Label("Bus 3");
        lbus3.setFont(new Font("Segoe UI Semibold", 20));
        lbus3.setTextFill(Color.web("#000000"));
        lbus3.setPadding(new Insets(10));

        Label lb2 = new Label("Bus");
        lb2.setFont(new Font("Segoe UI Semibold", 20));
        lb2.setTextFill(Color.web("#000000"));
        Image img2 = new Image("ui/images/bus.png");
        ImageView view2 = new ImageView(img2);
        view2.setPreserveRatio(true);
        lb2.setGraphic(view2);

        HBox hb2 = new HBox(lb2);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(100);
        hb2.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        VBox v1 = new VBox(lbus1,labelBus1,labelDelayBus1);
        v1.setAlignment(Pos.TOP_CENTER);
        v1.setSpacing(2);
        v1.setMinWidth(340);
        v1.setMaxWidth(340);
        v1.setMinHeight(200);
        v1.setMaxHeight(200);
        v1.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        VBox v2 = new VBox(lbus2,labelBus2,labelDelayBus2);
        v2.setAlignment(Pos.TOP_CENTER);
        v2.setSpacing(2);
        v2.setMinWidth(340);
        v2.setMaxWidth(340);
        v2.setMinHeight(200);
        v2.setMaxHeight(200);
        v2.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        VBox v3 = new VBox(lbus3,labelBus3,labelDelayBus3);
        v3.setAlignment(Pos.TOP_CENTER);
        v3.setSpacing(2);
        v3.setMinWidth(340);
        v3.setMaxWidth(340);
        v3.setMinHeight(200);
        v3.setMaxHeight(200);
        v3.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");


        Label lb3 = new Label("Bus locations");
        lb3.setFont(new Font("Segoe UI Semibold", 20));
        lb3.setTextFill(Color.web("#000000"));
        Image img3 = new Image("ui/images/Bus_it.png");
        ImageView view3 = new ImageView(img3);
        view3.setPreserveRatio(true);
        lb3.setGraphic(view3);

        HBox hb3 = new HBox(lb3);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(100);
        hb3.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");
        hb3.setMaxWidth(440);
        hb3.setMinWidth(400);

        HBox hboxBus = new HBox(pane);
        hboxBus.setAlignment(Pos.TOP_LEFT);
        hboxBus.setSpacing(10);
        hboxBus.setMinWidth(400);
        hboxBus.setMaxWidth(440);
        hboxBus.setMinHeight(200);
        hboxBus.setMaxHeight(200);
        hboxBus.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        HBox hboxBus2 = new HBox(pane2);
        hboxBus2.setAlignment(Pos.TOP_LEFT);
        hboxBus2.setSpacing(10);
        hboxBus2.setMinWidth(400);
        hboxBus2.setMaxWidth(440);
        hboxBus2.setMinHeight(200);
        hboxBus2.setMaxHeight(200);
        hboxBus2.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        HBox hboxBus3 = new HBox(pane3);
        hboxBus3.setAlignment(Pos.TOP_LEFT);
        hboxBus3.setSpacing(10);
        hboxBus3.setMinWidth(400);
        hboxBus3.setMaxWidth(440);
        hboxBus3.setMinHeight(200);
        hboxBus3.setMaxHeight(200);
        hboxBus3.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        VBox Vcenter = new VBox(hb3,hboxBus,hboxBus2,hboxBus3);
        Vcenter.setAlignment(Pos.TOP_LEFT);
        Vcenter.setSpacing(5);
        Vcenter.setMinWidth(420);
        Vcenter.setMaxWidth(440);

        hBoxPosBuses = new HBox(labelPosBus1, labelPosBus2, labelPosBus3);
        hBoxPosBuses.setAlignment(Pos.CENTER);
        hBoxPosBuses.setSpacing(100);

        VBox vBoxGlobal = new VBox(hb2, v1,v2,v3);
        vBoxGlobal.setAlignment(Pos.TOP_LEFT);
        vBoxGlobal.setSpacing(5);
        vBoxGlobal.setMinWidth(340);
        vBoxGlobal.setMaxWidth(340);
        root.setRight(vboxBlocs);
        root.setLeft(vBoxGlobal);
        root.setCenter(Vcenter);
        root.setPrefSize(400, 400);
        root.setStyle("-fx-background-color: linear-gradient(from 30% 30% to 100% 100%, #5584AC, #FFF1BD);");
        root.setMargin(vBoxGlobal, new Insets(3));
        root.setMargin(Vcenter, new Insets(3));
        root.setMargin(vboxBlocs, new Insets(3));

        ScrollPane scroller = new ScrollPane(root);
        scroller.setFitToWidth(true);


        layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1350, 700);
        Scene scene2 = new Scene(root,1000,600);
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        Label l = new Label("Authentication State");
        l.setFont(new Font("Segoe UI Semibold", 24));

        Label busStat= new Label("Bus Authentication state:");
        busStat.setFont(new Font("Segoe UI Semibold", 20));
        busStat.setPadding(new Insets(-10,10,25,0));
        Bus1Auth = new Label("Bus 1 : not connected ");
        Bus2Auth = new Label("Bus 2 : not connected ");
        Bus3Auth = new Label("Bus 3 : not connected ");

        Image image1 = new Image("ui/images/cancel.png");
        Image image2 = new Image("ui/images/checked.png");
        ImageView view_1 = new ImageView(image1);
        view_1.setPreserveRatio(true);
        ImageView view_2 = new ImageView(image1);
        view_2.setPreserveRatio(true);
        ImageView view_3 = new ImageView(image1);
        view_3.setPreserveRatio(true);
        ImageView view_4 = new ImageView(image1);
        view_4.setPreserveRatio(true);
        ImageView view_5 = new ImageView(image1);
        view_5.setPreserveRatio(true);
        ImageView view_6 = new ImageView(image1);
        view_6.setPreserveRatio(true);
        ImageView view_7 = new ImageView(image1);
        view_7.setPreserveRatio(true);
        ImageView view_8 = new ImageView(image1);
        view_8.setPreserveRatio(true);

        view_c1 = new ImageView(image2);
        view_c1.setPreserveRatio(true);
        view_c2 = new ImageView(image2);
        view_c2.setPreserveRatio(true);
        view_c3 = new ImageView(image2);
        view_c3.setPreserveRatio(true);
        view_c4 = new ImageView(image2);
        view_c4.setPreserveRatio(true);
        view_c5 = new ImageView(image2);
        view_c5.setPreserveRatio(true);
        view_c6 = new ImageView(image2);
        view_c6.setPreserveRatio(true);
        view_c7 = new ImageView(image2);
        view_c7.setPreserveRatio(true);
        view_c8 = new ImageView(image2);
        view_c8.setPreserveRatio(true);

        Bus1Auth.setGraphic(view_1);
        Bus2Auth.setGraphic(view_2);
        Bus3Auth.setGraphic(view_3);

        Bus1Auth.setContentDisplay(ContentDisplay.RIGHT);
        Bus2Auth.setContentDisplay(ContentDisplay.RIGHT);
        Bus3Auth.setContentDisplay(ContentDisplay.RIGHT);

        Label stationStat= new Label("Stations Authentication state:");
        stationStat.setFont(new Font("Segoe UI Semibold", 20));
        stationStat.setPadding(new Insets(-20,10,25,0));
        StationsBachAuth = new Label("Stations Bach Djerah : not connected ");
        StationsBabAuth= new Label("Stations Bab Ezzouar : not connected ");
        StationsDarAuth = new Label("Stations Dar El Beida : not connected ");
        StationsHammediAuth = new Label("Stations Hammedi : not connected     ");
        StationsHarrachAuth = new Label("Stations Harrach : not connected        ");

        StationsBachAuth.setGraphic(view_4);
        StationsBabAuth.setGraphic(view_5);
        StationsDarAuth.setGraphic(view_6);
        StationsHammediAuth.setGraphic(view_7);
        StationsHarrachAuth.setGraphic(view_8);

        StationsBachAuth.setContentDisplay(ContentDisplay.RIGHT);
        StationsBabAuth.setContentDisplay(ContentDisplay.RIGHT);
        StationsDarAuth.setContentDisplay(ContentDisplay.RIGHT);
        StationsHammediAuth.setContentDisplay(ContentDisplay.RIGHT);
        StationsHarrachAuth.setContentDisplay(ContentDisplay.RIGHT);

        buttonAuth = new Button("GO TO THE DASHBOARD");
        buttonAuth.setVisible(false);
        Image image3 = new Image("ui/images/next.png");
        ImageView viewb = new ImageView(image3);
        viewb.setPreserveRatio(true);
        buttonAuth.setGraphic(viewb);
        buttonAuth.setId("button");
        buttonAuth.setContentDisplay(ContentDisplay.RIGHT);
        buttonAuth.setOnAction(e -> stage.setScene(scene2));

        VBox vb1 = new VBox(busStat,Bus1Auth,Bus2Auth,Bus3Auth);
        vb1.setAlignment(Pos.TOP_LEFT);
        vb1.setSpacing(10);
        vb1.setMinWidth(400);
        vb1.setMaxWidth(500);
        vb1.setMinHeight(310);
        vb1.setMaxHeight(310);
        vb1.setPadding(new Insets(50));
        vb1.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        VBox vb2 = new VBox(stationStat,StationsBachAuth,StationsBabAuth,StationsDarAuth,StationsHarrachAuth,StationsHammediAuth);
        vb2.setAlignment(Pos.TOP_LEFT);
        vb2.setSpacing(10);
        vb2.setMinWidth(400);
        vb2.setMaxWidth(500);
        vb2.setMinHeight(310);
        vb2.setMaxHeight(310);
        vb2.setPadding(new Insets(50));
        vb2.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-background-radius: 10;");

        HBox hb1 = new HBox(vb1,vb2);
        hb1.setSpacing(100);
        hb1.setMinWidth(600);
        hb1.setMaxWidth(720);
        hb1.setMinHeight(410);
        hb1.setMaxHeight(410);
        hb1.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(l,hb1,buttonAuth);
        layout.setStyle("-fx-background-color: linear-gradient(from 30% 30% to 100% 100%, #5584AC, #FFE6BC);");


        stage.setScene(scene);
        stage.setTitle("Test window");
        stage.show();

        instance = this;

        try {
            manager = new Manager();
            threadManager = new Thread(manager);
            threadManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
        try {
            synchronized (manager) {
                manager.notify();
            }
            threadManager.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}