import javafx.beans.property.StringProperty;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GUI extends Application {

    private CARD c1 = new CARD(5326, 10000);
    private History H1 = new History();
    private String ts;
    private  int x;
    private Stage window;
    private Scene mainScene;
    private Scene scene2;
    private Button bnLogin;
    private Button bnExit;
    private Button bnExit2;
    private Button bninquiry;
    private Button bnDeposit;
    private Button bnWithdrawal;
    private Button bnHistory;
    private Button bnDep;
    private Button bnBk;
    private Button bnwith;
    private Button bnBk2;
    private Button bnBk3;
    private Button bnBk4;
    private Button bnBk5;
    private Button bnBk6;
    private Button bnOK;
    public Button bnPrev;
    public Button bnNext;
    private Scene depScene;
    private Scene withdrawalScene;
    private Scene inqScene;
    private Scene subScene;
    private Scene subScene2;
    private Scene histScene;
    private Scene invScene;


    @Override
    public void start(Stage primaryStage) {

        ///////////////////////////////// WINDOWS ////////////////////////////////
        // main window
        window = primaryStage;
        window.setTitle("ATM Application");

        //deposit window
        Stage windowdep = new Stage();
        windowdep.initModality(Modality.APPLICATION_MODAL);
        windowdep.setTitle("Deposit");

        // withdrawal window
        Stage windowWithdrawal = new Stage();
        windowWithdrawal.initModality(Modality.APPLICATION_MODAL);
        windowWithdrawal.setTitle("Withdrawal");

        // invalid window
        Stage windowinV =new Stage();
        windowinV.initModality(Modality.APPLICATION_MODAL);

        ////////////////////////////   CHILDREN /////////////////////////////////////////////////


        //Children of mainscene
        bnLogin = new Button("Login");
        bnLogin.setDefaultButton(true);
        bnExit = new Button("Exit");
        Label L1= new Label("Enter your card number:");
        TextField CardNumber = new TextField();

        //children of scene2
        bnDeposit= new Button("Deposit");
        bnWithdrawal= new Button("Withdrawal");
        bnHistory= new Button("History");
        Label L2= new Label(" Choose Operation:");
        bnExit2 = new Button("Exit");
        bninquiry= new Button ("Inquiry");


        // children of depscene
        Label L3= new Label("Enter deposit amount:");
        GridPane.setConstraints(L3,0,0);
        TextField depText = new TextField();
        GridPane.setConstraints(depText,0,1);
        bnDep = new Button("Submit");
        bnDep.setDefaultButton(true);
        GridPane.setConstraints(bnDep,0,2);
        bnBk = new Button("Back to main menu");
        GridPane.setConstraints(bnBk,1,2);

        // children of subcene
        Label L6= new Label("Deposit operation was Successful");
        bnBk4 = new Button("Back to main menu");
        bnBk4.setDefaultButton(true);
        Label L7= new Label("Your new balance is".concat(Double.toString(c1.getBalance())));

        // children of subcene2
        Label L8= new Label("Withdrawal operation was Successful");
        bnBk5 = new Button("Back to main menu");
        bnBk5.setDefaultButton(true);
        Label L9= new Label("Your new balance is".concat(Double.toString(c1.getBalance())));


        // children of withdrawal scene

        Label L4= new Label("Enter withdrawal amount:");
        GridPane.setConstraints(L4,0,0);
        TextField withText = new TextField();
        GridPane.setConstraints(withText,0,1);
        bnwith = new Button("Submit");
        bnwith.setDefaultButton(true);
        GridPane.setConstraints(bnwith,0,2);
        bnBk2 = new Button("Back to main menu");
        GridPane.setConstraints(bnBk2,1,2);

        // children of inquiry scene
        Label L5 = new Label("your balance is ");
        GridPane.setConstraints(L5,0,0);
        bnBk3 = new Button("Back to main menu");
        bnBk3.setDefaultButton(true);
        GridPane.setConstraints(bnBk3,0,1);

        // children of histScene
        Label L10 =new Label("History of transactions");
        GridPane.setConstraints(L10,5,0);
        Label L11 =new Label();
        GridPane.setConstraints(L11,5,5);
        bnPrev = new Button("Previous");
        GridPane.setConstraints(bnPrev,4,10);
        bnNext = new Button("Next");
        GridPane.setConstraints(bnNext,6,10);
        bnBk6 = new Button("Back to main menu");
        GridPane.setConstraints(bnBk6,7,13);

        //children of invalid scene
        Label L12= new Label("Invalid");
        bnOK =  new Button("Ok");
        bnOK.setDefaultButton(true);




////////////////////////////   LAYOUTS /////////////////////////////////////////////////

        //Layout of main scene
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(L1,CardNumber, bnLogin,bnExit);

        //layout of second scene

        VBox layoutV = new VBox(10);
        layoutV.setPadding(new Insets(20, 20, 20, 20));
        layoutV.getChildren().addAll(bnDeposit,bnWithdrawal,bnHistory,bnExit2,bninquiry);

        HBox layoutH = new HBox(10);
        layoutH.setPadding(new Insets(20, 20, 20, 20));
        layoutH.getChildren().addAll(bnExit2);
        layoutH.setAlignment(Pos.CENTER_RIGHT);



        BorderPane layoutB = new BorderPane();
        layoutB.setTop(L2);
        layoutB.setLeft(layoutV);
        layoutB.setBottom(layoutH);

        // layout of depscene
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.getChildren().addAll(L3,depText,bnDep,bnBk);

        //layout of subscene
        VBox layoutV2 = new VBox(10);
        layoutV2.setPadding(new Insets(20, 20, 20, 20));
        layoutV2.getChildren().addAll(L6,L7,bnBk4);


        //layout of withdrawal scene

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.getChildren().addAll(L4,withText,bnwith,bnBk2);

        //layout of subscene2
        VBox layoutV3 = new VBox(10);
        layoutV3.setPadding(new Insets(20, 20, 20, 20));
        layoutV3.getChildren().addAll(L8,L9,bnBk5);

        //layout of inquiry scene

        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
        grid3.setHgap(10);
        grid3.getChildren().addAll(L5,bnBk3);

        // layout of hist scene
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(20, 20, 20, 20));
        grid4.setVgap(8);
        grid4.setHgap(10);
        grid4.getChildren().addAll(L10,L11,bnPrev,bnNext,bnBk6);

        //layout of invalid scene
        VBox layoutV4 = new VBox(10);
        layoutV4.setPadding(new Insets(20, 20, 20, 20));
        layoutV4.getChildren().addAll(L12,bnOK);



        /////////////////////////  ACTION BUTTONS  ////////////////////////////////////////////////////

        //main scene action buttons
        bnLogin.setOnAction( e -> {

            if(isInt(CardNumber.getText())&&c1.findCard(Integer.parseInt(CardNumber.getText()))){
            window.setScene(scene2);
            }
            else
                windowinV.showAndWait();
        } );

        bnExit.setOnAction(e -> window.close());
        //second scene action buttons
        bnDeposit.setOnAction(e -> windowdep.showAndWait());
        bnExit2.setOnAction(e -> window.close());
        bnWithdrawal.setOnAction(e -> windowWithdrawal.showAndWait());
        bninquiry.setOnAction(e ->{
            H1.saveTrans("your balance is  ".concat(Double.toString(c1.getBalance())));
            L5.setText("Your balance is ".concat(Double.toString(c1.getBalance())));
            window.setScene(inqScene);
        });
        bnHistory.setOnAction(e ->window.setScene(histScene));



        //depscene action buttons

        bnBk.setOnAction(e ->windowdep.close());
        bnDep.setOnAction(e ->{
            if (isInt(depText.getText())){
            c1.deposit(Integer.parseInt(depText.getText()));
            H1.saveTrans("your deposit amount was ".concat(depText.getText()));
            L7.setText("Your new balance is ".concat(Double.toString(c1.getBalance())));
            windowdep.setScene(subScene); }

        });

        //subcene deposit action buttons
        bnBk4.setOnAction(e -> {

            windowdep.setScene(depScene);
            windowdep.close();
        });


        //withdrawalscene action buttons
        bnBk2.setOnAction(e ->windowWithdrawal.close());
        bnwith.setOnAction(e ->{
            if (isInt(withText.getText())&&c1.withdrawal(Integer.parseInt(withText.getText()))) {
                H1.saveTrans("Your withdrawal amount was ".concat(withText.getText()));
                L9.setText("Your new balance is ".concat(Double.toString(c1.getBalance())));
                windowWithdrawal.setScene(subScene2);
            }
            else
                windowinV.showAndWait();


        });

        //subcene2 withdrawal action buttons
        bnBk5.setOnAction(e -> {

            windowWithdrawal.setScene(withdrawalScene);
            windowWithdrawal.close();
        });

        //inquiry scene action buttons
        bnBk3.setOnAction(e->window.setScene(scene2));

        // hist scene action buttons

        bnPrev.setOnAction(e-> {
            bnNext.setDisable(false);
            ts=H1.Previous();
            L11.setText(ts);
            x=H1.retK();
            if (x==0||x==90) {
                bnPrev.setDisable(true);
            }

        });
        bnNext.setOnAction(e -> {
            bnPrev.setDisable(false);
            ts=H1.Next();
            L11.setText(ts);
            x=H1.retK();
            if (x==4||x==90)
                bnNext.setDisable(true);

        } );

        bnBk6.setOnAction(e->{
            bnNext.setDisable(false);
            bnPrev.setDisable(false);
            L11.setText("");
            window.setScene(scene2);
        });


        bnOK.setOnAction(e->{
            windowinV.close();
        });

////////////////////////////   SCENES /////////////////////////////////////////////////

        // main scene
        mainScene = new Scene(layout, 400, 250);
        window.setScene(mainScene);
        //second scene
        scene2= new Scene(layoutB,400,300);

        // depscene
        depScene= new Scene(grid,700,300);
        windowdep.setScene(depScene);

        //subcene
        subScene= new Scene(layoutV2,400,300);

        //withdrawal scene
        withdrawalScene= new Scene(grid2,700,300);
        windowWithdrawal.setScene(withdrawalScene);


        //subcene2
        subScene2= new Scene(layoutV3,400,300);

        //inquiry scene
        inqScene= new Scene(grid3,400,250);

        // hist scene
        histScene= new Scene(grid4,700,400);

        //invalid scene
        invScene =new Scene(layoutV4,200,150);
        windowinV.setScene(invScene);



        window.show();
    }

    //Validate age
    private boolean isInt(String text){
        try{
            int num = Integer.parseInt(text);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    }


