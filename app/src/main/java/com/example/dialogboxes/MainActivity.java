package com.example.dialogboxes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alertDialog = findViewById(R.id.alert_dialog);
        alertDialog.setOnClickListener(clickListenerDialog1);

        Button alertDialog2 = findViewById(R.id.alert_dialog_2);
        alertDialog2.setOnClickListener(clickListenerDialog2);

        Button alertDialogList = findViewById(R.id.alert_dialog_list);
        alertDialogList.setOnClickListener(clickListenerDialogList);

        Button alertDialogListSingle = findViewById(R.id.alert_dialog_list_radiobuttons);
        alertDialogListSingle.setOnClickListener(clickListenerDialogListSingle);

        Button alertDialogListMulti = findViewById(R.id.alert_dialog_list_checkboxes);
        alertDialogListMulti.setOnClickListener(clickListenerDialogListMulti);

        Button alertDialogCustom = findViewById(R.id.alert_dialog_custom);
        alertDialogCustom.setOnClickListener(clickListenerDialogCustom);


        Button fragmentCustomBuilder = findViewById(R.id.fragment_custom);
        fragmentCustomBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCustomFragment dialog = new DialogCustomFragment();
                dialog.show(getSupportFragmentManager(), "любой тэг");
            }
        });


        Button fragmentDialogBuilder = findViewById(R.id.fragment_dialog_custom);
        fragmentDialogBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuilderFragment dialogBuilderFragment = new DialogBuilderFragment();
                dialogBuilderFragment.show(getSupportFragmentManager(), "любой тэг");
            }
        });
    }


    public void onResultDialogFragment (String answer){
        Log.d("TAG", " отобразили  " + answer);
    }


    private final View.OnClickListener clickListenerDialogCustom = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            View frameLayout = getLayoutInflater().inflate(R.layout.dialog_custom, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setView(frameLayout)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EditText editText = frameLayout.findViewById(R.id.edit_text);
                            Log.d("TAG", " selected " + editText.getText().toString());
                        }
                    });


            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


    private final View.OnClickListener clickListenerDialog1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String stringExtractor = MainActivity.this.getResources().getString(R.string.dialog_1_message); // пример. сложый способ доставать стрингу
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setMessage(R.string.dialog_1_message)
                    .setPositiveButton(R.string.yes, dialogListener);


            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };
    private final View.OnClickListener clickListenerDialog2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setMessage(R.string.dialog_1_message)
                    .setPositiveButton(R.string.yes, dialogListener)
                    .setNegativeButton(R.string.no, dialogListener)
                    .setNeutralButton(R.string.other, dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private final DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.d("TAG", "onClick() called with: dialogInterface = [" + dialogInterface + "], i = [" + i + "]");
        }
    };


    private final View.OnClickListener clickListenerDialogList = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] item = getResources().getStringArray(R.array.variants);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setItems(item, dialogListener);
//                    .setPositiveButton(R.string.yes, dialogListener)
//                    .setNegativeButton(R.string.no,dialogListener)
//                    .setNeutralButton(R.string.other,dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


    private int chosen = -1;
    private final View.OnClickListener clickListenerDialogListSingle = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] variants = getResources().getStringArray(R.array.variants);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setSingleChoiceItems(variants, chosen, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            chosen = i;
                            Log.d("TAG", "RadioButtony  = [" + dialogInterface + "], i = [" + i + "]");
                        }
                    })
                .setPositiveButton(R.string.yes, dialogListener)
                    .setNegativeButton(R.string.no, dialogListener)
                    .setNeutralButton(R.string.other, dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };



    private boolean[] chosenBox = {false, false, false};
    private final View.OnClickListener clickListenerDialogListMulti = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] variants = getResources().getStringArray(R.array.variants);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.dialog_1_title)
                    .setMultiChoiceItems(variants, chosenBox, new DialogInterface.OnMultiChoiceClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            chosenBox[i] = b;
                        }
                    })
                    .setPositiveButton(R.string.yes, dialogListener)
                    .setNegativeButton(R.string.no, dialogListener)
                    .setNeutralButton(R.string.other, dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


}