package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lucy on 02-08-2015.
 */
public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<MenuContents> data = Collections.emptyList();

    public MenuRecyclerViewAdapter(Context context, List<MenuContents> data)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.menu_custom_row,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        MenuContents current = data.get(position);
        holder.title.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //VIEWHOLDER CLASS

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView title;
        CardView card;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.info_text);
            card = (CardView)itemView.findViewById(R.id.card_view);

//            int pos=
//            switch (pos)
//            {
//                case 0 :
//                    card.setBackgroundColor(Color.CYAN);
//                    title.setBackgroundColor(Color.CYAN);
//                    break;
//                case 1 :
//                    card.setBackgroundColor(Color.BLUE);
//                    title.setBackgroundColor(Color.BLUE);
//                    break;
//                case 2 :
//                    card.setBackgroundColor(Color.GRAY);
//                    title.setBackgroundColor(Color.GRAY);
//                    break;
//                case 3 :
//                    card.setBackgroundColor(Color.YELLOW);
//                    title.setBackgroundColor(Color.YELLOW);
//                    break;
//                case 4 :
//                    card.setBackgroundColor(Color.GREEN);
//                    title.setBackgroundColor(Color.GREEN);
//                    break;
//            }
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            final Intent intent;
            String text = title.getText().toString();

            switch (text)
            {
                case "Exhibition":
                    Toast.makeText(context,"Exhibition",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,ExhibitionsSlideTabActivity.class);
                    break;

                case "Cynosure Quiz":
                    Toast.makeText(context,"CynosureQuiz",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,CynosureQuiz.class);
                    break;

                case "Paper Presentation":
                    Toast.makeText(context,"Paper Presentation",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,PaperPresentation.class);
                    break;

                case "Project Competition":
                    Toast.makeText(context,"Project Competition",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,ProjectCompetition.class);
                    break;

                case "Best Idea":
                    Toast.makeText(context,"Best Idea",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,BestIdea.class);
                    break;

                case "Welcome to SJCET":
                    Toast.makeText(context,"See you at SJCET :) (please look out for updates in play store)",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,MainActivity.class);
                    break;

//                case "More":
//                    Toast.makeText(context,"More",Toast.LENGTH_SHORT).show();
//                    intent = null;
//                    break;

                default:
                    Toast.makeText(context,"Please try again",Toast.LENGTH_SHORT).show();
                    intent = new Intent(context,MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}