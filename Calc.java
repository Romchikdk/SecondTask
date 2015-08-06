package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * This class implements logic of author1 calculator, also implements view of the calculator.
 *
 * @author SobolRR
 */
public class Calc extends Application {
    /**
     * Menu Bar and it's components.
     */
    private MenuBar menuBar;
    private MenuItem exit;
    private MenuItem author;
    /**
     * Label for display numbers and operations.
     */
    protected Label label;
    /**
     * TextField for input numbers.
     */
    protected TextField textField;
    /**
     * Button for calculator. Responsible for entering numbers and range of operation to perform.
     */
    protected Button btnMc;
    protected Button btnMr;
    protected Button btnMs;
    protected Button btnMp;
    protected Button btnMd;
    protected Button btnBackSpace;
    protected Button btnCe;
    protected Button btnC;
    protected Button btnPlusMinus;
    protected Button btnSqrt;
    protected Button btn7;
    protected Button btn8;
    protected Button btn9;
    protected Button btnDivide;
    protected Button btnPercent;
    protected Button btn4;
    protected Button btn5;
    protected Button btn6;
    protected Button btnMultiply;
    protected Button btnHardDivide;
    protected Button btn1;
    protected Button btn2;
    protected Button btn3;
    protected Button btnSubtract;
    protected Button btnEqual;
    protected Button btn0;
    protected Button btnPoint;
    protected Button btnAdd;

    /**
     * Panel for placing controls.
     */
    private AnchorPane root;

    /**
     * Object of class Author.
     */
    private Author author1;

    /**
     * Variable to check the status of the operation.
     */
    private boolean operationCompleted;

    /**
     * Variable to check button pressed or no.
     */
    private boolean buttonPress;

    /**
     * Variable to store result operation with Memory button.
     */
    private BigDecimal resultM;

    /**
     * Variable  to store temporary values.
     */
    private BigDecimal buffer;

    /**
     * The variable that stores the result of the calculator.
     */
    private BigDecimal result;

    /**
     * Stores the number of characters in particular, rounds the result with that precicsion.
     * //
     */
    private BigDecimal precision;

    /**
     * Variable that stores the second number of operation.
     */
    private BigDecimal second;

    /**
     * Variable that stores the first number of operation.
     */
    private BigDecimal first;

    /**
     * Constant for the storage of the -1.
     */
    private static final BigDecimal MINUS_ONE = new BigDecimal(-1);

    /**
     * Constant for the storage of the 100.
     */
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    /**
     * Boundary number of characters in the text field and label to change the font.
     * If value more large Edge size, font to be smaller.
     */
    private static final int EDGE_SIZE = 11;

    /**
     * Boundary number of characters in label to change the font.
     * If value more large Edge size, font to be smaller.
     */
    private static final int EDGE_SIZE_FOR_LABEL_OUTPUT = 26;

    /**
     * The constant for the builder whose length is the boundary for the output text field.
     */
    private static final BigDecimal BIG_NUMBER = new BigDecimal("9999999999999999.49999999999999");

    /**
     * Format for for the output of large numbers.
     */
    private static final DecimalFormat BIG_DECIMAL_FORMAT = new DecimalFormat("#.##############E0");

    /**
     * Format for  the output of small float numbers.
     */
    private static final DecimalFormat BIG_DECIMAL_FORMAT_FOR_SMALL_NUMBER = new DecimalFormat("#.################");

    /**
     * Format for the output of ordinary numbers.
     */
    private static final DecimalFormat SMALL_DECIMAL_FORMAT = new DecimalFormat("###.################");

    /**
     * The string that notify user.
     */
    private static final String POSITIVE_VALUE = "Value must be positive";

    /**
     * The string that notify user.
     */
    private static final String DIVIDE_ZERO = "you can not divide by zero";

    /**
     * String for add in textField and label zero.
     */
    private static final String ZERO = "0";

    /**
     * The number of digits that are not rounded.
     */
    private static final int MAX_SCALE = 500;

    /**
     * The accuracy of the output value.
     */
    private static final int MAX_PRECISION = 32;

    /**
     * The number of digits that are not rounded of the output.
     */
    private static final int MAX_SIZE = 16;

    /**
     * MathContext for output result.
     */
    private static final MathContext mcForOutput = new MathContext(16, RoundingMode.HALF_UP);

    /**
     * MathContext for output result.
     */
    private static final MathContext mcForOperation = new MathContext(MAX_PRECISION, RoundingMode.HALF_UP);

    /**
     * Collection Map for store KeyEvent.
     */
    protected Map<KeyCode, Button> keyEventMap = new HashMap<>();

    /**
     * Collection Map for store Button.
     */
    protected Map<String, Button> accelerators = new HashMap<>();

    /**
     * Variable to store the last operation.
     */
    private static Operator lastOperation;

    /**
     * check button shift press
     */
    private boolean isShiftPressed = false;

    /**
     * check button shift press
     */
    private boolean isEqualPressed = true;

    /**
     * check button Sqrt press
     */
    private boolean isSqrt = false;

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This method is responsible for assembly applications.
     *
     * @param primaryStage container on which to build applications.
     * @throws Exception
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        addBtn0();
        addBtn1();
        addBtn2();
        addBtn3();
        addBtn4();
        addBtn5();
        addBtn6();
        addBtn7();
        addBtn8();
        addBtn9();
        addBtnBackSpace();
        addBtnC();
        addBtnSubtract();
        addBtnCe();
        addBtnDivide();
        addBtnEqual();
        addBtnHardDivide();
        addBtnMc();
        addBtnMd();
        addBtnMp();
        addBtnMr();
        addBtnMs();
        addBtnMultiply();
        addBtnPercent();
        addBtnPlusMinus();
        addBtnPoint();
        addBtnSqrt();
        addBtnAdd();
        addTextField();
        addMenu();
        addLabel();
        putButtons();

        Pane pane = new Pane();
        pane.getChildren().addAll(textField, label);

        primaryStage.setTitle("calculator");

        root = new AnchorPane();

        root.getChildren().addAll(pane, btnMr, btnMc, btnMs, btnMp, btnMd, btnBackSpace, btnCe, btnC, btnPlusMinus, btnSqrt, btn7, btn8,
                btn9, btnDivide, btnPercent, btn4, btn5, btn6, btnMultiply, btnHardDivide, btn1, btn2, btn3, btnSubtract, btnEqual, btn0, btnPoint, btnAdd, menuBar); // pane
        AnchorPane.setTopAnchor(menuBar, 0.0);
        AnchorPane.setTopAnchor(pane, 25.0);
        AnchorPane.setLeftAnchor(btnMc, 7.0);
        AnchorPane.setLeftAnchor(btnMr, 47.0);
        AnchorPane.setLeftAnchor(btnMs, 87.0);
        AnchorPane.setLeftAnchor(btnMp, 127.0);
        AnchorPane.setLeftAnchor(btnMd, 167.0);
        AnchorPane.setLeftAnchor(btnBackSpace, 7.0);
        AnchorPane.setLeftAnchor(btnCe, 47.0);
        AnchorPane.setLeftAnchor(btnC, 87.0);
        AnchorPane.setLeftAnchor(btnPlusMinus, 127.0);
        AnchorPane.setLeftAnchor(btnSqrt, 167.0);
        AnchorPane.setLeftAnchor(btn7, 7.0);
        AnchorPane.setLeftAnchor(btn8, 47.0);
        AnchorPane.setLeftAnchor(btn9, 87.0);
        AnchorPane.setLeftAnchor(btnDivide, 127.0);
        AnchorPane.setLeftAnchor(btnPercent, 167.0);
        AnchorPane.setLeftAnchor(btn4, 7.0);
        AnchorPane.setLeftAnchor(btn5, 47.0);
        AnchorPane.setLeftAnchor(btn6, 87.0);
        AnchorPane.setLeftAnchor(btnMultiply, 127.0);
        AnchorPane.setLeftAnchor(btnHardDivide, 167.0);
        AnchorPane.setLeftAnchor(btn1, 7.0);
        AnchorPane.setLeftAnchor(btn2, 47.0);
        AnchorPane.setLeftAnchor(btn3, 87.0);
        AnchorPane.setLeftAnchor(btnSubtract, 127.0);
        AnchorPane.setLeftAnchor(btnEqual, 167.0);
        AnchorPane.setLeftAnchor(btn0, 7.0);
        AnchorPane.setLeftAnchor(btnPoint, 87.0);
        AnchorPane.setLeftAnchor(btnAdd, 127.0);

        author1 = new Author();
        author1.author();

        primaryStage.setScene(new Scene(root, 200, 264));
        primaryStage.setResizable(false);
        primaryStage.getScene().getStylesheets().add("/sample/css.css");

        primaryStage.show();
        root.requestFocus();

        resultM = BigDecimal.ZERO;
        buffer = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        precision = new BigDecimal("100000000000000"); // Which number, because this number has scale which equal zero and quantity characters in number which equal marginally possible to output


        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                primaryStage.close();
            }
        });

        author.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                author1.newStage.show();

            }
        });
        putKeyEvent();
        pressKeyBoard();
    }

    /**
     * This method checks the number of entered characters, and change the font on the basis of these changes.
     */
    private void processField() {
        String text = textField.getText();
        if (isInputTextCheck(text)) {
            textField.setId("SmallTextField");
            textField.setText("");
            textField.setText(text);
        } else {
            textField.setId("BigTextField");
            textField.setAlignment(Pos.BOTTOM_RIGHT);
            textField.setText("");
            textField.setText(text);

        }
    }

    /**
     * This method output operation result on screen.
     */
    private void outputText() {
        String formatted;
        if (operationCompleted && !textField.getText().equals(DIVIDE_ZERO)) {
            BigDecimal output = new BigDecimal(result.toString(), mcForOutput);
            if (BigDecimal.ONE.compareTo(result.abs()) > 0) {
                formatted = BIG_DECIMAL_FORMAT_FOR_SMALL_NUMBER.format(output);
            } else if (result.abs().compareTo(BIG_NUMBER) > 0) {
                formatted = BIG_DECIMAL_FORMAT.format(output);
            } else {
                formatted = SMALL_DECIMAL_FORMAT.format(output);
            }
            textField.setText(formatted);
            processField();
        }
    }

    /**
     * This method performs all operations together.
     */
    private void operationForOperationButton() {
        root.requestFocus();
        operationCompleted = true;
    }

    /**
     * This method check text in label.
     *
     * @return true if label empty or has character '0' else false.
     */
    private boolean isTextLabel() {
        String text = label.getText();
        return text.isEmpty() || text.equals("0");
    }

    /**
     * This method perform logic after key[0-9] pressed.
     *
     * @param button values of button.
     */
    private void functionForPressButton(Operator button) {
        String text = label.getText();
        root.requestFocus();
        buttonPress = true;
        if (operationCompleted) {
            textField.setText(ZERO);
            operationCompleted = false;
        }
        if (isEqualPressed) {
            result = BigDecimal.ZERO;
            buffer = BigDecimal.ZERO;
        }
        textField.setText(deleteZeroForNumber(textField.getText()));
        if (textField.getLength() < MAX_SIZE) {
            textField.appendText(String.valueOf(button.getChar()));
        }
        if (text.equals((ZERO))) {
            cleanLabel();
        }
        processField();
    }

    /**
     * This method clean Label.
     */
    private void cleanLabel() {
        label.setText("");
        label.setTextAlignment(TextAlignment.RIGHT);
    }

    /**
     * This method delete all the extra zeros from the number..
     *
     * @param textFieldText text from a text field.
     * @return modified builder.
     */
    private String deleteZeroForNumber(String textFieldText) {
        if (textFieldText.charAt(0) == '0') {
            if (textFieldText.length() > 1 && textFieldText.charAt(1) == '.') {
                return textFieldText;
            } else
                return "";
        } else
            return textFieldText;

    }

    /**
     * This method performs operation after press operation lastOperation.
     */
    private void operation() {

        if (buttonPress) {
            if (lastOperation == Operator.PLUS) {
                result = result.add(buffer, mcForOperation);
            } else if (lastOperation == Operator.MINUS) {
                result = result.subtract(buffer, mcForOperation);
            } else if (lastOperation == Operator.MULTIPLY) {
                result = result.multiply(buffer, mcForOperation);
            } else if (lastOperation == Operator.DIVIDE) {
                result = result.divide(buffer, MAX_SCALE, RoundingMode.HALF_UP);
            }
        }
    }

    /**
     * Reads the numbers (first and second).
     */
    private void readNumbers() {
        first = readVarFirst();
        second = new BigDecimal(textField.getText().replace(',', '.'));
    }

    /**
     * This method check label size and changes it format
     *
     * @param textLabel text label
     * @return Changed text for label.
     */
    private String bigLabel(String textLabel) {
        StringBuilder builder = new StringBuilder(textLabel);
        String string;
        int length = textLabel.length();
        if (length > EDGE_SIZE_FOR_LABEL_OUTPUT) {
            string = "<<" + builder.substring(length - EDGE_SIZE_FOR_LABEL_OUTPUT, length);
            label.setTextAlignment(TextAlignment.LEFT);
        } else {
            string = builder.toString();
        }
        return string;
    }

    /**
     * This method Take the square root of the number
     *
     * @param number the number from which you want to take the square root
     * @return the obtained value(BigDecimal)
     */
    private BigDecimal sqrt(BigDecimal number) {
        return BigDecimal.valueOf(StrictMath.sqrt(number.doubleValue()));
    }

    /**
     * This method check number of characters in text
     *
     * @param textTextField text from a text field
     * @return true if there is larger EDGE_SIZE else false
     */
    private boolean isInputTextCheck(String textTextField) {
        return textTextField.length() > EDGE_SIZE;
    }

    /**
     * this method make operation and is responsible for processing entering data
     *
     * @param operator lastOperation arithmetic operation
     */
    private void makeOperation(Operator operator) {
        String text = textField.getText();
        String stringLabel = label.getText();
        if (isTextLabel()) {
            label.setText(stringLabel + deletePoint(text) + " " + operator.getChar());
        } else {
          StringBuilder  builder = new StringBuilder(stringLabel);
            if (buttonPress) {
                first = readVarFirst();
                second = new BigDecimal(text.replace(',', '.'));
                buffer = second;
                result = first;
                label.setText(bigLabel(builder + " " + deletePoint(text) + " " + operator.getChar()));
                operation();
                operationCompleted = true;
                buttonPress = false;
                outputText();

            } else {
                builder.delete(builder.length() - 1, builder.length());
                label.setText(builder.toString() + operator.getChar()); // изменить
            }
        }
        lastOperation = operator;

    }

    /**
     * This method delete redundant point
     *
     * @param textTextField textField text
     * @return rectification text
     */
    private String deletePoint(String textTextField) {
        StringBuilder builder = new StringBuilder(textTextField);
        if (builder.charAt(builder.length() - 1) == '.') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    /**
     * Method help input first variable for make operation.
     *
     * @return first variable
     */
    private BigDecimal readVarFirst() {
        if (result.signum() == 0) {
            String stringLabel = label.getText();
            return new BigDecimal(stringLabel.substring(0, stringLabel.length() - 2));
        }
        return result;
    }

    /**
     * Action for press button mr.
     */
    private void mr() {
        operationForOperationButton();
        BigDecimal value = new BigDecimal(resultM.toString(), mcForOutput);
        String output;
        DecimalFormat formatter = (resultM.abs().compareTo(BIG_NUMBER) > 0) ? BIG_DECIMAL_FORMAT : SMALL_DECIMAL_FORMAT;
        output = formatter.format(value);
        textField.setText(output);
    }

    /**
     * Action for press button Md.
     */
    private void md() {

        operationForOperationButton();
        buffer = new BigDecimal(textField.getText());
        resultM = resultM.subtract(buffer, mcForOperation);

    }

    /**
     * Action for press button Mp.
     */
    private void mp() {

        operationForOperationButton();
        buffer = new BigDecimal(textField.getText());
        resultM = resultM.add(buffer, mcForOperation);

    }

    /**
     * Action for press button mc.
     */
    private void mc() {
        operationForOperationButton();
        resultM = BigDecimal.ZERO;
    }

    /**
     * Action for press button BackSpace.
     */
    private void backSpace() {

        root.requestFocus();
        if (textField.getText().equals("")) {
            textField.setText(ZERO);
        }
        if (!operationCompleted) {
            String text = textField.getText();
            textField.setText(text.substring(0, text.length() - 1));
            if (textField.getText().length() == 0) {
                textField.setText(ZERO);
            }
        }
        processField();

    }

    /**
     * Action for press button C.
     */
    private void c() {
        root.requestFocus();
        cleanLabel();
        result = BigDecimal.ZERO;
        isEqualPressed = true;
        ce();
    }

    /**
     * Action for press button Ce.
     */
    private void ce() {
        root.requestFocus();
        operationCompleted = false;
        textField.setText(ZERO);
        buffer = BigDecimal.ZERO;
        processField();
    }

    /**
     * Action for press button PlusMinus.
     */
    private void plusMinus() {
        root.requestFocus();
        first = new BigDecimal(textField.getText().replace(',', '.'));
        first = first.multiply(MINUS_ONE);
        if (operationCompleted) {
            result = first;
        }
        buffer = first;
        textField.setText(first.toString());

    }

    /**
     * Action for press button Sqrt.
     */
    private void pressSqrt() {
        operationForOperationButton();
        lastOperation = Operator.SQRT;
        isEqualPressed = true;
        isSqrt = true;

        if (result.signum() == 0) {
            first = new BigDecimal(textField.getText());
        } else {
            first = result;
        }

        precision = first;
        if (first.signum() == -1) {
            textField.setText(POSITIVE_VALUE);
        } else {
            result = sqrt(first);
            buffer = result;
            textField.setText(SMALL_DECIMAL_FORMAT.format(result));
        }
    }

    /**
     * Action for press button Percent.
     */
    private void percent() {
        operationForOperationButton();
        if (isEqualPressed) {
            label.setText(ZERO);
            textField.setText(ZERO);
        } else {
            readNumbers();
            buffer = first.multiply(second).divide(ONE_HUNDRED, MAX_SCALE, RoundingMode.HALF_UP);
        }
        textField.setText(SMALL_DECIMAL_FORMAT.format(buffer));

    }

    /**
     * Action for press button HardDiv.
     */
    private void hardDivide() {

        String text = textField.getText();
        isEqualPressed = true;
        operationForOperationButton();

        if ((lastOperation != Operator.ERROR)) {
            if (result.signum() == 0) {
                first = new BigDecimal(text);
            } else {
                first = result;
            }
            precision = first;
            if (first.signum() == 0) {
                lastOperation = Operator.ERROR;
                textField.setText(DIVIDE_ZERO);
            } else {
                result = BigDecimal.ONE.divide(first, MAX_SCALE, RoundingMode.HALF_UP);
                outputText();
            }
        }

    }

    /**
     * Action for press button Equal.
     */
    private void equal() {

        root.requestFocus();
        buttonPress = false;
        if (!isSqrt) {
            precision = BIG_NUMBER;
        } else {
            operationCompleted = false;
        }
        if (!isEqualPressed) {
            readNumbers();
        }
        if (isEqualPressed && operationCompleted) {
            buttonPress = true;
            operation();
        } else if (lastOperation == Operator.PLUS) {
            result = first.add(second, mcForOperation);
        } else if (lastOperation == Operator.MINUS) {
            result = first.subtract(second, mcForOperation);
        } else if (lastOperation == Operator.MULTIPLY) {
            result = first.multiply(second, mcForOperation);
            if (isSqrt) {
                int temp = (precision.scale() == 0) ? (precision.toString().length()) : (precision.toString().length() - 1);
                result = result.setScale(MAX_SCALE, RoundingMode.HALF_UP).round(new MathContext(temp));
            }
            precision = result;
        } else if (lastOperation == Operator.DIVIDE) {
            if (second.signum() == 0) {
                cleanLabel();
                textField.setText(DIVIDE_ZERO);
                lastOperation = Operator.ERROR;
                operationCompleted = false;
            } else {
                result = first.divide(second, MAX_SCALE, RoundingMode.HALF_UP);
            }
            precision = result;
        }

        if (!isEqualPressed) {
            buffer = second;
            operationCompleted = true;
            isEqualPressed = true;
            isSqrt = false;
        }


        outputText();
        cleanLabel();
    }

    /**
     * Action for press button Point.
     */
    private void point() {
        root.requestFocus();
        String text = textField.getText();
        if (text.length() > 0 && text.lastIndexOf('.') == -1) {
            textField.appendText(".");
        }
    }

    /**
     * Action for press button Add.
     */
    private void add() {
        operationForOperationButton();
        makeOperation(Operator.PLUS);
        isEqualPressed = false;
    }

    /**
     * Action for press button Subtract.
     */
    private void subtract() {
        operationForOperationButton();
        makeOperation(Operator.MINUS);
        isEqualPressed = false;

    }

    /**
     * Action for press button Multiply.
     */
    private void multiply() {
        operationForOperationButton();
        makeOperation(Operator.MULTIPLY);
        isEqualPressed = false;
    }

    /**
     * Action for press button Divivde.
     */
    private void divide() {
        operationForOperationButton();
        makeOperation(Operator.DIVIDE);
        isEqualPressed = false;
    }

    /**
     * This method add Button 0 on the Pane
     */
    private void addBtn0() {
        btn0 = new Button("0");
        btn0.setLayoutX(50);
        btn0.setLayoutY(234);
        btn0.setPrefSize(74, 26);
        btn0.setId("NumBut");
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.ZERO);
            }
        });
    }

    /**
     * This method add Button 1 on the Pane
     */
    private void addBtn1() {
        btn1 = new Button("1");
        btn1.setLayoutX(50);
        btn1.setLayoutY(204);
        btn1.setPrefSize(34, 26);
        btn1.setId("NumBut");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.ONE);
            }
        });
    }

    /**
     * This method add Button 2 on the Pane
     */
    private void addBtn2() {

        btn2 = new Button("2");
        btn2.setLayoutX(50);
        btn2.setLayoutY(204);
        btn2.setPrefSize(34, 26);
        btn2.setId("NumBut");

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.TWO);
            }
        });
    }

    /**
     * This method add Button 3 on the Pane
     */
    private void addBtn3() {
        btn3 = new Button("3");
        btn3.setLayoutX(50);
        btn3.setLayoutY(204);
        btn3.setPrefSize(34, 26);
        btn3.setId("NumBut");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.THREE);
            }
        });
    }

    /**
     * This method add Button 4 on the Pane
     */
    private void addBtn4() {
        btn4 = new Button("4");
        btn4.setLayoutX(50);
        btn4.setLayoutY(174);
        btn4.setPrefSize(34, 26);
        btn4.setId("NumBut");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.FOUR);
            }
        });
    }

    /**
     * This method add Button 5 on the Pane
     */
    private void addBtn5() {
        btn5 = new Button("5");
        btn5.setLayoutX(50);
        btn5.setLayoutY(174);
        btn5.setPrefSize(34, 26);
        btn5.setId("NumBut");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.FIVE);
            }
        });
    }

    /**
     * This method add Button 6 on the Pane
     */
    private void addBtn6() {
        btn6 = new Button("6");
        btn6.setLayoutX(50);
        btn6.setLayoutY(174);
        btn6.setPrefSize(34, 26);
        btn6.setId("NumBut");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.SIX);
            }
        });
    }

    /**
     * This method add Button 7 on the Pane
     */
    private void addBtn7() {
        btn7 = new Button("7");
        btn7.setLayoutX(50);
        btn7.setLayoutY(144);
        btn7.setPrefSize(34, 26);
        btn7.setId("NumBut");
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.SEVEN);
            }
        });
    }

    /**
     * This method add Button 8 on the Pane
     */
    private void addBtn8() {
        btn8 = new Button("8");
        btn8.setLayoutX(50);
        btn8.setLayoutY(144);
        btn8.setPrefSize(34, 26);
        btn8.setId("NumBut");
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.EIGHT);
            }
        });
    }

    /**
     * This method add Button 9 on the Pane
     */
    private void addBtn9() {
        btn9 = new Button("9");
        btn9.setLayoutX(50);
        btn9.setLayoutY(144);
        btn9.setPrefSize(34, 26);
        btn9.setId("NumBut");
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                functionForPressButton(Operator.NINE);
            }
        });
    }

    /**
     * This method add Button mc on the Pane and implements the click event handler for the button
     * Delete values of memory
     */
    private void addBtnMc() {
        btnMc = new Button("MC");
        btnMc.setPrefSize(34, 26);
        btnMc.setLayoutX(50);
        btnMc.setLayoutY(84);
        btnMc.setId("IntBut");
        btnMc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mc();
            }
        });
    }

    /**
     * This method add Button mr on the Pane and implements the click event handler for the button
     * Read values of Memory
     */
    private void addBtnMr() {
        btnMr = new Button("MR");
        btnMr.setLayoutX(120);
        btnMr.setLayoutY(84);
        btnMr.setPrefSize(34, 26);
        btnMr.setId("IntBut");
        btnMr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mr();
            }
        });
    }

    /**
     * This method add Button Ms on the Pane and implements the click event handler for the button
     * Save values in Memory
     */
    private void addBtnMs() {
        btnMs = new Button("MS");
        btnMs.setLayoutX(120);
        btnMs.setLayoutY(84);
        btnMs.setPrefSize(34, 26);
        btnMs.setId("IntBut");
    }

    /**
     * This method add Button Mp on the Pane and implements the click event handler for the button
     * Add values in Memory
     */
    private void addBtnMp() {
        btnMp = new Button("M+");
        btnMp.setPrefSize(34, 26);
        btnMp.setLayoutY(84);
        btnMp.setLayoutX(70);
        btnMp.setId("IntBut");
        btnMp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mp();
            }
        });
    }

    /**
     * This method add Button Md on the Pane and implements the click event handler for the button
     * Subtrcut values of Memory
     */
    private void addBtnMd() {
        btnMd = new Button("M-");
        btnMd.setPrefSize(34, 26);
        btnMd.setLayoutY(84);
        btnMd.setLayoutX(50);
        btnMd.setId("IntBut");
        btnMd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                md();
            }
        });
    }

    /**
     * This method add Button BackSpase on the Pane and implements the click event handler for the button
     * Delete one character of text field
     */
    private void addBtnBackSpace() {
        btnBackSpace = new Button("⬅");
        btnBackSpace.setLayoutX(120);
        btnBackSpace.setLayoutY(114);
        btnBackSpace.setPrefSize(34, 26);
        btnBackSpace.setId("IntBut");
        btnBackSpace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backSpace();
            }
        });
    }

    /**
     * This method add Button CE on the Pane and implements the click event handler for the button
     * Delete text of the text field
     */
    private void addBtnCe() {
        btnCe = new Button("CE");
        btnCe.setLayoutX(50);
        btnCe.setLayoutY(114);
        btnCe.setPrefSize(34, 26);
        btnCe.setId("IntBut");
        btnCe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ce();
            }
        });
    }

    /**
     * This method add Button C on the Pane and implements the click event handler for the button
     * Delete text on the label and text field and delete vaules of the memory
     */
    private void addBtnC() {
        btnC = new Button("C ");
        btnC.setPrefSize(34, 26);
        btnC.setLayoutY(114);
        btnC.setLayoutX(120);
        btnC.setId("IntBut");
        btnC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c();
            }
        });
    }

    /**
     * This method add Button PlusMinus on the Pane and implements the click event handler for the button
     * multiplies the value -1
     */
    private void addBtnPlusMinus() {
        btnPlusMinus = new Button("±");
        btnPlusMinus.setLayoutX(50);
        btnPlusMinus.setLayoutY(114);
        btnPlusMinus.setPrefSize(34, 26);
        btnPlusMinus.setId("NumBut");
        btnPlusMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                plusMinus();
            }
        });
    }

    /**
     * This method add Button PlusMinus on the Pane and implements the click event handler for the button
     * Take the square root of the number
     */
    private void addBtnSqrt() {
        btnSqrt = new Button("√");
        btnSqrt.setLayoutX(50);
        btnSqrt.setLayoutY(114);
        btnSqrt.setPrefSize(34, 26);
        btnSqrt.setId("NumBut");
        btnSqrt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pressSqrt();
            }
        });
    }

    /**
     * This method add Button Divide on the Pane and implements the click event handler for the button
     * Responsible for the operation of division
     */
    private void addBtnDivide() {
        btnDivide = new Button("/");
        btnDivide.setLayoutX(50);
        btnDivide.setLayoutY(144);
        btnDivide.setPrefSize(34, 26);
        btnDivide.setId("NumBut");
        btnDivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                divide();
            }
        });
    }

    /**
     * This method add Button Percent on the Pane and implements the click event handler for the button
     * Calculates the percentage of the number of tasks
     */
    private void addBtnPercent() {
        btnPercent = new Button("%");
        btnPercent.setLayoutX(50);
        btnPercent.setLayoutY(144);
        btnPercent.setPrefSize(34, 26);
        btnPercent.setId("IntBut");
        btnPercent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                percent();
            }
        });
    }

    /**
     * This method add Button Multiply on the Pane and implements the click event handler for the button
     * Responsible for the operation of Multiply
     */
    private void addBtnMultiply() {
        btnMultiply = new Button("*");
        btnMultiply.setLayoutX(50);
        btnMultiply.setLayoutY(174);
        btnMultiply.setPrefSize(34, 26);
        btnMultiply.setId("NumBut");
        btnMultiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                multiply();
            }
        });
    }

    /**
     * This method add Button HardDivide on the Pane and implements the click event handler for the button
     * Gets the value of a division operation One unit on the job number
     */
    private void addBtnHardDivide() {
        btnHardDivide = new Button("1/x");
        btnHardDivide.setLayoutX(50);
        btnHardDivide.setLayoutY(174);
        btnHardDivide.setPrefSize(34, 26);
        btnHardDivide.setId("IntBut");
        btnHardDivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hardDivide();
            }
        });

    }

    /**
     * This method add Button Difference on the Pane and implements the click event handler for the button
     * Responsible for the operation of Difference
     */
    private void addBtnSubtract() {
        btnSubtract = new Button("-");
        btnSubtract.setLayoutX(50);
        btnSubtract.setLayoutY(204);
        btnSubtract.setPrefSize(34, 26);
        btnSubtract.setId("NumBut");
        btnSubtract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                subtract();
            }
        });

    }

    /**
     * This method add Button Equal on the Pane and implements the click event handler for the button
     * Performs calculations for a given operation
     */
    private void addBtnEqual() {
        btnEqual = new Button("=");
        btnEqual.setLayoutX(50);
        btnEqual.setLayoutY(204);
        btnEqual.setPrefSize(34, 56);
        btnEqual.setId("NumBut");
        btnEqual.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                equal();
            }
        });

    }

    /**
     * This method add Button Point on the Pane and implements the click event handler for the button
     * Converts number to a floating point number
     */
    private void addBtnPoint() {
        btnPoint = new Button(",");
        btnPoint.setLayoutX(50);
        btnPoint.setLayoutY(234);
        btnPoint.setPrefSize(34, 26);
        btnPoint.setId("NumBut");
        btnPoint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                point();
            }
        });

    }

    /**
     * This method add Button Add on the Pane and implements the click event handler for the button
     * Responsible for the operation of Add
     */
    private void addBtnAdd() {
        btnAdd = new Button("+");
        btnAdd.setLayoutX(50);
        btnAdd.setLayoutY(234);
        btnAdd.setPrefSize(34, 26);
        btnAdd.setId("NumBut");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                add();
            }
        });
    }

    /**
     * This method add TextField on the Pane and implements the click event handler for the TextField
     */
    private void addTextField() {
        textField = new TextField("0");
        textField.setPrefColumnCount(10);
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        textField.setLayoutX(8);
        //Inconsolata // todo
        textField.setPrefSize(193, 50);
        textField.setCursor(Cursor.HAND);
        textField.setEditable(false);
    }

    /**
     * This method add Menu Bar Difference on the Pane and implements the click event handler for the Menu Item.
     */
    private void addMenu() {
        Menu fileMenu = new Menu("File");
        exit = new MenuItem("Exit");
        Menu reference = new Menu("Reference");
        author = new MenuItem("Author");

        fileMenu.getItems().add(exit);
        reference.getItems().add(author);
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, reference);
        //menuBar.setPrefSize(210, 5);
    }

    /**
     * This method add Label on the Pane.
     */
    private void addLabel() {
        label = new Label("");
        label.setAlignment(Pos.BOTTOM_RIGHT);
        label.setStyle("-fx-font:normal 12pt Consolas;-fx-text-fill: Black;");
        label.setLayoutX(8);
        label.setPrefSize(188, 20);
    }

    /**
     * This method put button in map accelerators.
     */
    private void putButtons() {
        accelerators.put("btn0", btn0);
        accelerators.put("btn1", btn1);
        accelerators.put("btn2", btn2);
        accelerators.put("btn3", btn3);
        accelerators.put("btn4", btn4);
        accelerators.put("btn5", btn5);
        accelerators.put("btn6", btn6);
        accelerators.put("btn7", btn7);
        accelerators.put("btn8", btn8);
        accelerators.put("btn9", btn9);
        accelerators.put("btn0", btn0);
        accelerators.put("btnMc", btnMc);
        accelerators.put("btnMd", btnMd);
        accelerators.put("btnMp", btnMp);
        accelerators.put("btnMs", btnMs);
        accelerators.put("btnMr", btnMr);
        accelerators.put("btnBackSpace", btnBackSpace);
        accelerators.put("btnDivide", btnDivide);
        accelerators.put("btnSubtract", btnSubtract);
        accelerators.put("btnMultiply", btnMultiply);
        accelerators.put("btnAdd", btnAdd);
        accelerators.put("btnEqual", btnEqual);
        accelerators.put("btnPoint", btnPoint);
        accelerators.put("btnC", btnC);
        accelerators.put("btnCe", btnCe);
        accelerators.put("btnPercent", btnPercent);
        accelerators.put("btnPlusMinus", btnPlusMinus);
        accelerators.put("btnHardDivide", btnHardDivide);
        accelerators.put("btnSqrt", btnSqrt);
    }

    /**
     * This method put keyEventMap in map keyEventMap.
     */
    private void putKeyEvent() {
        keyEventMap.put(KeyCode.DIGIT0, btn0);
        keyEventMap.put(KeyCode.DIGIT1, btn1);
        keyEventMap.put(KeyCode.DIGIT2, btn2);
        keyEventMap.put(KeyCode.DIGIT3, btn3);
        keyEventMap.put(KeyCode.DIGIT4, btn4);
        keyEventMap.put(KeyCode.DIGIT5, btn5);
        keyEventMap.put(KeyCode.DIGIT6, btn6);
        keyEventMap.put(KeyCode.DIGIT7, btn7);
        keyEventMap.put(KeyCode.DIGIT8, btn8);
        keyEventMap.put(KeyCode.DIGIT9, btn9);
        keyEventMap.put(KeyCode.NUMPAD0, btn0);
        keyEventMap.put(KeyCode.NUMPAD1, btn1);
        keyEventMap.put(KeyCode.NUMPAD2, btn2);
        keyEventMap.put(KeyCode.NUMPAD3, btn3);
        keyEventMap.put(KeyCode.NUMPAD4, btn4);
        keyEventMap.put(KeyCode.NUMPAD5, btn5);
        keyEventMap.put(KeyCode.NUMPAD6, btn6);
        keyEventMap.put(KeyCode.NUMPAD7, btn7);
        keyEventMap.put(KeyCode.NUMPAD8, btn8);
        keyEventMap.put(KeyCode.NUMPAD9, btn9);
        keyEventMap.put(KeyCode.BACK_SPACE, btnBackSpace);
        keyEventMap.put(KeyCode.SLASH, btnDivide);
        keyEventMap.put(KeyCode.DECIMAL, btnDivide);
        keyEventMap.put(KeyCode.DIVIDE, btnDivide);
        keyEventMap.put(KeyCode.MINUS, btnSubtract);
        keyEventMap.put(KeyCode.SUBTRACT, btnSubtract);
        keyEventMap.put(KeyCode.MULTIPLY, btnMultiply);
        keyEventMap.put(KeyCode.ADD, btnAdd);
        keyEventMap.put(KeyCode.EQUALS, btnEqual);
        keyEventMap.put(KeyCode.COMMA, btnPoint);
        keyEventMap.put(KeyCode.ESCAPE, btnC);
        keyEventMap.put(KeyCode.DELETE, btnCe);
        keyEventMap.put(KeyCode.ENTER, btnEqual);
        keyEventMap.put(KeyCode.P, btnPercent);
    }

    private void pressKeyBoard() {

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (keyEventMap.containsKey(event.getCode()) && !isShiftPressed) {
                    keyEventMap.get(event.getCode()).fire();
                }

                if (event.getCode() == KeyCode.SHIFT) {
                    isShiftPressed = true;
                }

                if (isShiftPressed) {
                    if (event.getCode() == KeyCode.DIGIT8) {
                        keyEventMap.get(KeyCode.MULTIPLY).fire();
                    }
                    if (event.getCode() == KeyCode.DIGIT5) {
                        keyEventMap.get(KeyCode.P).fire();
                    }
                    if (event.getCode() == KeyCode.EQUALS) {
                        keyEventMap.get(KeyCode.ADD).fire();
                    }
                }
                System.out.println(event.getCode());
            }
        });

        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SHIFT) {
                    isShiftPressed = false;
                }
            }
        });
    }

    /**
     * Enumeration of calculator operations
     */
    private enum Operator {
        ONE('1'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        ZERO('0'),
        PLUS('+'),
        MINUS('-'),
        DIVIDE('/'),
        MULTIPLY('*'),
        SQRT('√'),
        ERROR('E');

        private char c;

        Operator(char c) {
            this.c = c;
        }

        public char getChar() {
            return c;
        }
    }

}









