package ibotrox.leptocephalus.geobaby.testtablayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lucy on 01-08-2015.
 */
public class CompetitionsRecyclerViewAdapter extends RecyclerView.Adapter<CompetitionsRecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<CompetitionRecyclerViewContents> data = Collections.emptyList();

    public CompetitionsRecyclerViewAdapter(Context context, List<CompetitionRecyclerViewContents> data)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.competitions_custom_row,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        CompetitionRecyclerViewContents current = data.get(position);
//        holder.title.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //VIEWHOLDER CLASS

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
//        TextView title;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
//            title = (TextView) itemView.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            final Intent intent;

            switch (pos)
            {
                case 0:
                    //home
                    intent = new Intent(context,HomeActivity.class);
                    break;

                case 1:
                    //rules and regulations
                    intent = new Intent(context,RulesandRegulationsActivity.class);
                    break;

                case 2:
                    //questions
                    intent = new Intent(context,QuestionsActivity.class);
                    break;

                case 3:
                    //reach us
                    intent = new Intent(context,ReachUsActivity.class);
                    break;

                case 4:
                    //contact us
                    intent = new Intent(context,ContactUsActivity.class);
                    break;

                case 5:
                    //about us
                    intent = new Intent(context,AboutUsActivity.class);
                    break;

                default:
                    intent = new Intent(context,MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}