package ru.aomikhailov.chessdrawmastercdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.Nullable;

import java.util.List;

public class MyEnterPlayerAdapter extends ArrayAdapter<Player> {

    private LayoutInflater inflater;
    private int layout;
    private List<Player> players;

    public MyEnterPlayerAdapter(Context context, int resource, List<Player> players) {
        super(context, resource, players);
        this.players = players;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (position < players.size() / 2) {
            View view = inflater.inflate(this.layout, parent, false);
            TextView NameWhitePlayer = view.findViewById(R.id.WhitePlayer);
            TextView NameBlackPlayer = view.findViewById(R.id.BlackPlayer);
            Button result = view.findViewById(R.id.ButtonResult);
            Player WhitePlayer = players.get(position);
            Player BlackPlayer = players.get((players.size())/2+position);
            result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupMenuWithResult(v);
                }

                private void showPopupMenuWithResult(View v) {
                    PopupMenu popupMenu = new PopupMenu(getContext(), v);
                    popupMenu.getMenu().add(1, R.id.menu1, 1, "0");
                    popupMenu.getMenu().add(1, R.id.menu2, 2, "1");
                    popupMenu.getMenu().add(1, R.id.menu3, 3, "1/2");
                    popupMenu.show();
                }

            });
            NameWhitePlayer.setText(WhitePlayer.getSurname() + " " + WhitePlayer.getName().charAt(0) + ".");
            NameBlackPlayer.setText(BlackPlayer.getSurname() + " " + BlackPlayer.getName().charAt(0) + ".");
            return view;
        } else {
            View view = inflater.inflate(R.layout.empty, parent, false);
            return view;
        }
    }
}

