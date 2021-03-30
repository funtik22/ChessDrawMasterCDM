package ru.aomikhailov.chessdrawmastercdm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogAddPlayers extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Ввод игроков")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialog_add_players)
                .setPositiveButton("Добавить", null)
                .setNegativeButton("Отмена", null)
                .create();
    }
}
