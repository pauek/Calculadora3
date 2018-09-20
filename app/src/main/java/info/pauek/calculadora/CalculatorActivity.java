package info.pauek.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    // Model
    private String num = ""; // Aquí és on està guardat el número actual!
    private String numant = "";
    private char operacio = ' ';

    // Referències a la Vista
    private TextView numview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview = findViewById(R.id.numview);
        numview.setText(num);
    }

    public void onClickDigit(View view) {
        Button b = (Button)view;
        num += b.getText().toString();
        numview.setText(num);
    }

    public void onClickOperator(View view) {
        Button b = (Button)view;
        numant = num;
        num = "";
        operacio = b.getText().toString().charAt(0);
        numview.setText(num);
    }

    public void onClickEquals(View view) {
        double x = Double.valueOf(num);
        double xant = Double.valueOf(numant);
        switch (operacio) {
            case '+':
                num = Double.toString(xant + x);
                break;
            case '-':
                num = Double.toString(xant - x);
                break;
        }
        numview.setText(num);
    }
}
