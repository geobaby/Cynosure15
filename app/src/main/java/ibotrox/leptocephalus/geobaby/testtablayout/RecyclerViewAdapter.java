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
 * Created by Lucy on 27-07-2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<RecyclerViewContent> data = Collections.emptyList();

    public RecyclerViewAdapter(Context context, List<RecyclerViewContent> data)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerViewContent current = data.get(position);

        holder.icon.setImageResource(current.iconId);
        holder.title.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView icon;
        TextView title;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            title = (TextView) itemView.findViewById(R.id.listText);
        }

        @Override
        public void onClick(View v) {
            int pos = getPosition();
            final Intent intent;

            switch (pos)
            {
                case 0:
                    //home
                    intent = new Intent(context,MainActivity.class);
                    break;

                case 1:
                    //What is Cynosure?
                    intent = new Intent(context,WhatisCynosure.class);
                    break;

//
//                case 2:
//                    //questions
//                    intent = new Intent(context,QuestionsActivity.class);
//                    break;
//
//                case 3:
//                    //reach us
//                    intent = new Intent(context,ReachUsActivity.class);
//                    break;

                case 2:
                    //rules and regulations
                    intent = new Intent(context,RulesandRegulationsActivity.class);
                    break;

                case 3:
                    //contact us
                    intent = new Intent(context,ContactUsActivity.class);
                    break;

                case 4:
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
