package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

	boolean actionPerformed = false;
	private String identificator="+", MEMORIE = "";
	private double memorie;
	private double arg1=0;
	private double arg2=1;
	private double rezultat=0;
	private int decimals=2;

	
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label DEG, RAD, GRA, M, secondText;
    @FXML
    private TextField mainText;
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunct, 
    				ACBtn, CBtn, divide, egal, minus, multiply, plus,
    				numInv, MPlus, MRBtn, plusMinus,
    				DRGBtn, PIBtn, InvBtn, sinBtn, cosBtn, tanBtn,
    				lnBtn, factorialBtn, squareBtn, sqrtBtn, powBtn, radicalBtn,
    			    closeBtn;
    @FXML
    void ACBtnHandler(ActionEvent event) {
    	reset();
    }
    
    @FXML
    void CBtnHandler(ActionEvent event) {
    	mainText.setText("");
    }
    
    @FXML
    void divideHandler(ActionEvent event) {
    	secondText.setText(mainText.getText() + " / ");
		identificator = "/";
		computeOperation();
    }
    
    @FXML
    void multiplyHandler(ActionEvent event) {
    	secondText.setText(mainText.getText() + " * ");
		identificator = "*";
		computeOperation();
    }
    
    @FXML
    void plusHandler(ActionEvent event) {
    	secondText.setText(mainText.getText() + " + ");
		identificator = "+";
		computeOperation();		
    }
    
    @FXML
    void minusHandler(ActionEvent event) {
    	secondText.setText(mainText.getText() + " - ");
		identificator = "-";
		computeOperation();
    }    
    //TASTATURA NUMERICA
    @FXML
    void btn0Handler(ActionEvent event) {
    	if(actionPerformed){mainText.setText("");secondText.setText("");}
    	actionPerformed = false;
    	if(!mainText.getText().equals("0")){mainText.setText(mainText.getText() + "0"); } 	
    }    
    @FXML
    void btn1Handler(ActionEvent event) {
    	NumericalBottonHandle(btn1);
    }
    @FXML
    void btn2Handler(ActionEvent event) {
    	NumericalBottonHandle(btn2);	
    }
    @FXML
    void btn3Handler(ActionEvent event) {
    	NumericalBottonHandle(btn3); 	
    }
    @FXML
    void btn4Handler(ActionEvent event) {
    	NumericalBottonHandle(btn4); 	
    }
    @FXML
    void btn5Handler(ActionEvent event) {
    	NumericalBottonHandle(btn5); 	
    }
    @FXML
    void btn6Handler(ActionEvent event) {
    	NumericalBottonHandle(btn6);	
    }
    @FXML
    void btn7Handler(ActionEvent event) {
    	NumericalBottonHandle(btn7); 	
    }
    @FXML
    void btn8Handler(ActionEvent event) {
    	NumericalBottonHandle(btn8); 	
    }
    @FXML
    void btn9Handler(ActionEvent event) {
    	NumericalBottonHandle(btn9);	
    }
    @FXML
    void btnPunctHandler(ActionEvent event) {
    	if(actionPerformed){mainText.setText("");secondText.setText("");}
    	actionPerformed = false;
    		if(mainText.getText().equals("")){mainText.setText("0.");}
    		if(!mainText.getText().contains(".")){mainText.setText(mainText.getText() + "."); } 	
    }  
    //SFARSIT TASTATURA NUMERICA

    //OPERATII MEMORIE
    @FXML
    void numInvBtnHandler(ActionEvent event) {
    	if(!mainText.getText().isEmpty()){
	    	double argument = Double.parseDouble(mainText.getText());
	    	decimals = Math.max(getNumberOfDigits(argument), 6);
	    	mainText.setText(String.format( "%." +decimals +"f"  ,1/argument));
	    	actionPerformed =true;
    	}
    }
    @FXML
    void MPlusBtnHandler(ActionEvent event) {	
    	if(! ((mainText.getText().equals("0"))|| (mainText.getText().equals("")))){
    	MEMORIE = mainText.getText();
    	M.setText("Memorie: " + MEMORIE);
    	actionPerformed = true;}
    	else{secondText.setText("");
    		 M.setText("");
    		 MEMORIE = "";
    	}    	
    }
    @FXML
    void MRBtnHandler(ActionEvent event) {
    	if(!MEMORIE.equals("")){mainText.setText(MEMORIE);}
    }
    @FXML
    void plusMinusHandler(ActionEvent event) {
    	if(!(mainText.getText().isEmpty() || mainText.getText().equals("-"))){
	    	double argument = Double.valueOf(mainText.getText());
	    	if(argument>0){
	    		mainText.setText( "-"+(String.format(("%." +getNumberOfDigits(argument) +"f"), argument )));
	    	}
	    	if(argument<0){
	    		mainText.setText( (String.format(("%." +getNumberOfDigits(argument) +"f"), Math.abs(argument ))));
	    	}
    	}
    	else{
    		mainText.setText("-");
    	}    	
    } 
    //SFARSIT OPERATII MEMORIE
    
    //OPERATII TRIGONOMETRICE
    double trigFactor = 0.017453292519943295;//DEG to RAD
    int trigIncrement = 1;
    String DRGStatus = "degrees";
    boolean firstFunction = true;
    @FXML
    void DRGBtnHandler(ActionEvent event) {
    	trigIncrement++;
    	if(trigIncrement==1){  
    		DRGStatus = "degrees";
    		trigFactor = 0.017453292519943295;
    		DEG.setText("DEG");
    		GRA.setText("");
    	}
    	if(trigIncrement==2){	
    		DRGStatus = "radians";
    		trigFactor = 1;
    		DEG.setText("");
    		RAD.setText("RAD");
    	}
    	if(trigIncrement==3){	
    		DRGStatus = "grads";
    		trigFactor = 0.015707963267948;
    		GRA.setText("GRA");
    		RAD.setText("");
    	}
    	trigIncrement = trigIncrement%3;
    }
    @FXML
    void PIBtnHandler(ActionEvent event) {
    	mainText.setText( String.format("%.8f", Math.PI)  );
    }
    @FXML
    void InvBtnHandler(ActionEvent event) {
    	if (firstFunction ==true){ 
    		firstFunction = false;
    		sinBtn.setText("asin");
    		cosBtn.setText("acos");
    		tanBtn.setText("atan");
    		}
    	else {
    		firstFunction = true;
    		sinBtn.setText("sin");
    		cosBtn.setText("cos");
    		tanBtn.setText("tan");
    	}
    }
    @FXML
    void sinBtnHandler(ActionEvent event) {
    	if(!mainText.getText().isEmpty()){
    		double argument = Double.parseDouble(mainText.getText());
    		if(firstFunction){
		    	rezultat = Math.sin(trigFactor*argument);
		    	ComputeTrigonometricalOperation("sin", DRGStatus);
	    	}
    		else{
    			if( -1<= argument && 1>= argument ){
    				rezultat = Math.asin(argument);
    				ComputeTrigonometricalOperation("asin", "");
    			}
    			else{
    				secondText.setText("argumentul trebuie sa fie intre -1 si 1");
    			}
    		}
    	}
    }
    @FXML
    void cosBtnHandler(ActionEvent event) {
    	if(!mainText.getText().isEmpty()){
        	double argument = Double.parseDouble(mainText.getText());
    		if(firstFunction){
		    	rezultat = Math.cos(trigFactor*argument);
		    	ComputeTrigonometricalOperation("cos", DRGStatus);
	    	}
    		else{
    			if( -1<= argument && 1>= argument ){
    				rezultat = Math.acos(argument);
    				ComputeTrigonometricalOperation("acos", "");
    			}
    			else{
    				secondText.setText("argumentul trebuie sa fie intre -1 si 1");
    			}
    		}
    	}
    }
    @FXML
    void tanBtnHandler(ActionEvent event) {
    	if(!mainText.getText().isEmpty()){
        	double argument = Double.parseDouble(mainText.getText());
    		if(firstFunction){
		    	rezultat = Math.tan(trigFactor*argument);
		    	ComputeTrigonometricalOperation("tan", DRGStatus);
	    	}
    		else{
    			rezultat = Math.atan(argument);
    			ComputeTrigonometricalOperation("atan", "");	    			
    		}
    	}
    }  
    
    //SFARSIT OPERATII TRIGONOMETRICE
    
    //OPERATII PUTERI SI LOGARITMI
    @FXML
    void lnBtnHandler(ActionEvent event) {
    	if(!   (mainText.getText().isEmpty() || mainText.getText().equals("-"))  ){
	    	double argument = Double.parseDouble(mainText.getText());
	    	if(argument > 0){
	    	decimals = Math.max(getNumberOfDigits(argument), 6);
	    	secondText.setText("ln(" + argument + ") = ");
	    	mainText.setText(String.format( "%." +decimals +"f"  , Math.log(argument)   ));
	    	actionPerformed =true;
	    	}
	    	else{
	    		secondText.setText("argumentul trebuie sa fie mai mare ca 0!");
	    	}
	    	actionPerformed = true;
    	}
    }  
    @FXML
    void factorialBtnHandler(ActionEvent event) {
    	if(!mainText.getText().isEmpty()){
    		double argument = Double.parseDouble(mainText.getText());
	        actionPerformed = true;
    		if(argument>2 && argument<=23){
	    		decimals = getNumberOfDigits(argument);
	    		if(decimals==0){
	    	        long fact = 1; // this  will be the result
	    	        for (long i = 1; i <= argument; i++) {
	    	            fact *= i;
	    	        }
	    	        secondText.setText(argument + "! = ");
	    	        mainText.setText(fact + "");
	    		}
    		}
    		else{
    			secondText.setText("argumentul trebuie sa fie un integ intre 3 si 23!");
    		}
    	}    	
    }    
    @FXML
    void squareBtnHandler(ActionEvent event) {
    	if(!   (mainText.getText().isEmpty() || mainText.getText().equals("-"))  ){
	    	double argument = Double.parseDouble(mainText.getText());
	    	decimals = getNumberOfDigits(argument);
	    	secondText.setText(argument + " ^2 = ");
	    	mainText.setText(String.format( "%." +decimals +"f"  , argument*argument   ));	    	
	    	actionPerformed = true;
    	}
    }  
    @FXML
    void sqrtBtnHandler(ActionEvent event) {
    	if(!   (mainText.getText().isEmpty() || mainText.getText().equals("-"))  ){
	    	double argument = Double.parseDouble(mainText.getText());
	    	decimals = Math.max(getNumberOfDigits(argument), 6);
	    	secondText.setText("√" + argument + " = ");
	    	argument = Math.sqrt(argument);
	    	if( (( (int)argument)  - argument) ==0  ){  decimals = 0;}	    	
	    	mainText.setText(String.format( "%." +decimals +"f"  , argument   ));
	    	actionPerformed = true;
    	}
    } 
    @FXML
    void powBtnHandler(ActionEvent event) {
    	secondText.setText(mainText.getText() + " ^ ");
		identificator = "^";
		computeOperation();
    } 
    @FXML
    void radicalBtnHandler(ActionEvent event) {
    	secondText.setText("Din baza: "+mainText.getText() + " radical de ordinul: " );
		identificator = "rad";
		computeOperation();
    } 
    //SFARSIT OPERATII PUTERI SI LOGARITMI    
    
    @FXML
    void egalBtnHandler(ActionEvent event) {
    	egalPressed();
    	System.out.println("egal pressed");
    }    
    
    //INITIALIZE
    @FXML
    void initialize() {   
    	AnchorPane.setFocusTraversable(true);
    	if(AnchorPane.isFocused()){System.out.println("anchor pane focused");}    	
    }
    //END OF INITIALIZE
    
    //Keyboard input
    @FXML
    void keboardListener(KeyEvent ke) {
    	//number input
    	if(  "123456789".contains( ke.getText() )   ){	
        	NumericalBottonHandle(ke);
        }
    	if(  ke.getCode().equals(KeyCode.DIGIT0)  || ke.getCode().equals(KeyCode.NUMPAD0)){	
        	if(actionPerformed){mainText.setText("");secondText.setText("");}
        	actionPerformed = false;
        	if(!mainText.getText().equals("0")){mainText.setText(mainText.getText() + "0"); } 	
        }
    	if(  ".".contains( ke.getText() )   ){	
    		if(actionPerformed){mainText.setText("");secondText.setText("");}
        	actionPerformed = false;
        		if(mainText.getText().equals("")){mainText.setText("0.");}
        		if(!mainText.getText().contains(".")){mainText.setText(mainText.getText() + "."); } 	
        }    	
    	//operation input
    	if(  "+-*/".contains( ke.getText()   )   ){	
    		if(ke.getText().equals("+")){   operationHandler("+");}
    		if(ke.getText().equals("-")){   operationHandler("-");}
    		if(ke.getText().equals("*")){   operationHandler("*");}
    		if(ke.getText().equals("/")){   operationHandler("/");}
        }
    	
    	//Enter key calls equal method
    	if(  ke.getCode().equals(KeyCode.ENTER) ){	
	    		egalPressed();
	     //   	System.out.println("egal din key listener");
        }
    }


    @FXML
    void mainTextEnterPressed(ActionEvent event) {
    	//egalPressed();
    	//System.out.println("egal din maintext");
     }
    
    //END OF Keyboard input
        
    //CLOSE BUTTON
    @FXML
    void closeBtnHandler(ActionEvent event) {
    	System.exit(0);
    }
    // END CLOSE

    public void computeOperation(){
		if(!mainText.getText().equals("")){
			memorie = Double.parseDouble(mainText.getText());
			arg1 = Double.parseDouble(mainText.getText());
			mainText.setText("");}
		else{arg1 = memorie;
		mainText.setText("");}		
	}
    public void operationHandler(String zz){//for simple operations
    	secondText.setText(mainText.getText() + " "+ zz+ " ");
		identificator = zz;
    	computeOperation();
    }
	public void reset(){
		mainText.setText("");
		secondText.setText("");
		arg1 = arg2 = 0;
		actionPerformed = false;
		M.setText("");
	}
	public int getNumberOfDigits(double zz){
		String z = String.valueOf(zz);
		if(!z.endsWith(".0")){
			return(z.length() - z.indexOf(".") - 1);
		}
		else return 0;
	}	
	public void NumericalBottonHandle(Button btn){//FOR BUTTONS
    	if(actionPerformed){mainText.setText(""); secondText.setText("");}
    	actionPerformed = false;
    	mainText.setText(mainText.getText() + btn.getText()); 
	}
	public void NumericalBottonHandle(KeyEvent ke){//FOR KEYS
    	if(actionPerformed){mainText.setText(""); secondText.setText("");}
    	actionPerformed = false;
    	mainText.setText(mainText.getText() + ke.getText()); 
	}
	public void ComputeTrigonometricalOperation(String status, String drgStatus){
		decimals = 6;
    	secondText.setText( status + "(" + mainText.getText()  + ") "+ drgStatus +" =" );
    	if( rezultat>0.99999 && rezultat<1.00001)  {rezultat =  1; decimals = 0;}
    	if(rezultat>-1.00001 && rezultat<-0.99999) {rezultat = -1; decimals = 0;}
        if(rezultat>-0.00001 && rezultat<0.00001)  {rezultat =  0; decimals = 0;}
    	mainText.setText(String.format( "%." +decimals +"f",   rezultat   ));
    	actionPerformed = true;		
	}
	public void egalPressed(){
		try{
    		
	    	if(!mainText.getText().equals("")){	arg2 = Double.parseDouble(mainText.getText());}    
	    	else{arg2 = 0;}
	    	
	    	if(!secondText.getText().contains("=")){
	    		secondText.setText(secondText.getText() + " " + arg2 + " = ");}
	    	else{secondText.setText(arg2 + " " + identificator + arg1 + " =");}	    	
			if (identificator.equals("+")){rezultat = arg1 + arg2;
						decimals = Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2));
			}
			if (identificator.equals("-")){rezultat = arg1 - arg2;
						decimals = Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2));
			}
			if (identificator.equals("*")){rezultat = arg1 * arg2;
						decimals = Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2));
			}
			if (identificator.equals("^")){rezultat = Math.pow(arg1, arg2);
						decimals = Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2));}
			if (identificator.equals("rad")){rezultat = Math.pow(arg1, (double)(1/arg2));
					decimals = Math.max(   Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2)), 7      );}
			if (identificator.equals("/")){
				if (arg2==0){rezultat = 0;}
				else {rezultat = arg1 / arg2;
						decimals = Math.max(5, Math.max(getNumberOfDigits(arg1), getNumberOfDigits(arg2)));}
			}
			mainText.setText(String.format(("%." +decimals +"f"),rezultat));
			
			actionPerformed = true;
		}
    	catch(Exception e){
    		e.printStackTrace();
    	}
	}
	    
}
