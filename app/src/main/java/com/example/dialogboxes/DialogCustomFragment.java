package com.example.dialogboxes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogCustomFragment extends DialogFragment {

    private EditText editText;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_dialog_custom, container, false);
        initView(view);
        initListener();

        // TODO
        return view;
    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String answer = editText.getText().toString();
                ((MainActivity) requireActivity()).onResultDialogFragment(answer);
                dismiss();
            }
        });
    }

    private void initView(View view) {
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.button_custom);
    }


}
