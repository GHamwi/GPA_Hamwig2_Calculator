
/**************** Created by George B. Hamwi Homework 2 *******************/

package com.example.gpa_hamwig2_calculator;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    /* Making enterable fields in order for the user to input their grades */

    private EditText Grade1;
    private EditText Grade2;
    private EditText Grade3;
    private EditText Grade4;
    private EditText Grade5;
    private Button Compute;
    private TextView Output;
    private TextView background;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /* Getting the variables imputed by the user in order to compute the GPA  */

        Grade1 = (EditText) findViewById(R.id.editText4);
        Grade2 = (EditText) findViewById(R.id.editText5);
        Grade3 = (EditText) findViewById(R.id.editText7);
        Grade4 = (EditText) findViewById(R.id.editText8);
        Grade5 = (EditText) findViewById(R.id.editText9);
        Compute = (Button) findViewById(R.id.button);
        Output = (TextView) findViewById(R.id.editText6);
        Output.setBackgroundColor(Color.TRANSPARENT);
        background = findViewById(R.id.textView);

    /* If the user has entered a number in the text field it will get the number in order to compute the GPA  */

        Compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         if (count % 2 == 0) {
             if (Grade1.getText().toString().equals("") ||
                 Grade2.getText().toString().equals("") ||
                 Grade3.getText().toString().equals("") ||
                 Grade4.getText().toString().equals("") ||
                 Grade5.getText().toString().equals(""))

    /* If the user does not enter a grade it will prompt them to "Enter Missing Grades"  */

         {
             Toast toast= Toast.makeText(MainActivity.this,"Enter Missing Grades",Toast.LENGTH_LONG);
             toast.show();
         }

    /* The GPA is computed here and the result is provided */
             else {
                  double g = Double.parseDouble(Grade1.getText().toString());
                  double h = Double.parseDouble(Grade2.getText().toString());
                  double i = Double.parseDouble(Grade3.getText().toString());
                  double j = Double.parseDouble(Grade4.getText().toString());
                  double k = Double.parseDouble(Grade5.getText().toString());
                  double z = (g + h + i + j + k) / 5;

                  Output.setText(String.valueOf(z));
                  Compute.setTextColor(Color.WHITE);

    /* Changes the background color based on the users final GPA grade  */

                 if (z >= 80) {
                     background.setBackgroundColor(Color.GREEN);
                 } else if (z <= 60) {
                     background.setBackgroundColor(Color.RED);
                 } else if (z > 60 && z < 80) {
                     background.setBackgroundColor(Color.YELLOW);
                 }

    /* After the users GPA is calculated the compute button turns into a clear form button */
                count++;
                Compute.setText("Clear Form");

                }}

    /* When the user clicks the "Clear Form" button it will clear everything in the application
    * and make it ready for the user to calculate another GPA, also the button is now to its original "Compute GPA" state  */
                else {
                    Grade1.setText("");
                    Grade2.setText("");
                    Grade3.setText("");
                    Grade4.setText("");
                    Grade5.setText("");
                    Output.setText("");
                    background.setBackgroundResource(R.color.WHITE);
                    Compute.setText("Compute GPA");
                    count++;
          }}
        });
      }}
