package com.example.dialogboxes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {

     private Button buttonOk;
     private Button  buttonNo;

    public MyBottomSheetDialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_dialog, container, false);

        buttonOk = view.findViewById(R.id.button_OK);
        buttonNo = view.findViewById(R.id.button_Yes);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             ((MainActivity) requireActivity()).onResultDialogFragment("OK");
               if (onDialogListener!=null)
                    onDialogListener.pressOk();
                dismiss(); // close alert
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) requireActivity()).onResultDialogFragment("No");
                if (onDialogListener!=null)

                    onDialogListener.pressNo();
                dismiss();
            }
        });

        setCancelable(true);
        return view;


    }

    private OnDialogListener onDialogListener;

    public void setOnDialogListener(OnDialogListener onDialogListener) {
        this.onDialogListener = onDialogListener;
    }
}
