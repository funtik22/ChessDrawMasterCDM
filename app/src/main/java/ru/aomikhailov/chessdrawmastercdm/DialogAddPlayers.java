package ru.aomikhailov.chessdrawmastercdm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;


public class DialogAddPlayers extends DialogFragment {

    public interface  OnAsw{
        public void OnAsw(String name, String surname, String patronymic, Integer YearOfBirth, Integer Rating);
        }
        OnAsw mListener;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (OnAsw) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }

    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        return builder
                .setTitle("Ввод игроков")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(inflater.inflate(R.layout.dialog_add_players, null))
                .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText nameText = Objects.requireNonNull(getDialog()).findViewById(R.id.editTextPlayerName);
                        EditText surnameText = Objects.requireNonNull(getDialog()).findViewById(R.id.editTextPlayerSurname);
                        EditText patronymicText = Objects.requireNonNull(getDialog()).findViewById(R.id.editTextPlayerPatronymic);
                        EditText YearOfBirthText = Objects.requireNonNull(getDialog()).findViewById(R.id.editTextAgeOfBirth);
                        EditText RatingText = Objects.requireNonNull(getDialog()).findViewById(R.id.editTextRating);
                        mListener.OnAsw(nameText.getText().toString(), surnameText.getText().toString(), patronymicText.getText().toString(),
                                Integer.parseInt(YearOfBirthText.getText().toString()), Integer.parseInt(RatingText.getText().toString()));
                    }
                })
                .setNegativeButton("Отмена", null)
                .create();
    }

}
