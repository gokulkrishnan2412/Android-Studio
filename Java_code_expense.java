import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText foodExpenseEditText, petrolExpenseEditText, otherExpenseEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodExpenseEditText = findViewById(R.id.foodExpenseEditText);
        petrolExpenseEditText = findViewById(R.id.petrolExpenseEditText);
        otherExpenseEditText = findViewById(R.id.otherExpenseEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExpenses();
            }
        });
    }

    private void calculateExpenses() {
        double foodExpense = Double.parseDouble(foodExpenseEditText.getText().toString());
        double petrolExpense = Double.parseDouble(petrolExpenseEditText.getText().toString());
        double otherExpense = Double.parseDouble(otherExpenseEditText.getText().toString());

        double dailyExpense = foodExpense + petrolExpense + otherExpense;
        double weeklyExpense = dailyExpense * 7;
        double monthlyExpense = dailyExpense * getDaysInMonth();

        resultTextView.setText("Daily Expense: " + dailyExpense +
                "\nWeekly Expense: " + weeklyExpense +
                "\nMonthly Expense: " + monthlyExpense);
    }

    private int getDaysInMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}