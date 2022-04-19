package com.lufick.training;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogHelper {

    public void confirmDelete(Context context) {
        new MaterialAlertDialogBuilder(context)
                .setTitle("Dialog Title")
                .setMessage("Dialog msg, this is long msg")
                .setNegativeButton("Cancel", (dialog, which) -> {
                    Toast.makeText(context, "Clicked on Cancel", Toast.LENGTH_SHORT).show();
                })
                .setPositiveButton("Delete", (dialog, which) -> {
                    Toast.makeText(context, "Clicked on Delete", Toast.LENGTH_SHORT).show();
                }).show();
    }

}
