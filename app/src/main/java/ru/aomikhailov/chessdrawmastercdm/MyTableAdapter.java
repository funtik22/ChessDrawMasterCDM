package ru.aomikhailov.chessdrawmastercdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyTableAdapter extends ArrayAdapter <Player> {

    private LayoutInflater inflater;
    private int layout;
    private List<Player> players;

    public MyTableAdapter(Context context, int resource, List<Player> players) {
        super(context,resource, players);
        this.players = players;
        this.layout= resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view =inflater.inflate(this.layout, parent, false);
        TextView name = view.findViewById(R.id.name);
        TextView surname = view.findViewById(R.id.surname);
        TextView rating = view.findViewById(R.id.TextRating);
        TextView YearOfBirth = view.findViewById(R.id.TextYearOfBirth);
        TextView number = view.findViewById(R.id.number);

        Player player = players.get(position);

        name.setText(player.getName());
        surname.setText(player.getSurname());
        rating.setText(player.getRating().toString());
        YearOfBirth.setText(player.getYearOfBirth().toString());
        number.setText((player.getPoints().toString()));


        return view;
    }
}
