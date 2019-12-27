package com.example.app_insta.model.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_insta.R;
import com.example.app_insta.model.model.Post;
import com.example.app_insta.model.model.User;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    public Context mContext;
    public List<Post> mPost;

    private FirebaseUser firebaseUser;
    private Object User;

    public PostAdapter(Context mContext, List<Post> mPost) {
        this.mContext=mContext;
        this.mPost=mPost;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item, viewGroup,false);
        return new  PostAdapter.ViewHolder(view);
    }

    @Override
    public  void onBindViewHolder(@NonNull ViewHolder viewHolder, int i){
        firebaseUser=firebaseUser.getInstance().getCurrentUser();
        Post post= mPost.get(i);

        Glide.with(mContext).loadLibrary(post.getPostimage()).into(viewHolder.post_image);

        if (post.getDescription().equals("")){
            viewHolder.description.setVisibility(View.GONE);
        }else {
            viewHolder.description.setVisibility(View.VISIBLE);
            viewHolder.description.setText(post.getDescription());
        }
        publisherInfo(viewHolder.image_profile, viewHolder.username, viewHolder.publisher, post.getPublisher());
    }

    @Override
    public  int getItemCount() {
        return mPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image_profile, post_image, like, comm, save;
        public TextView username,likes,publisher,description,commnets;

        public ViewHolder(View view) {
            super(itemView);

            image_profile=itemView.findViewById(R.id.image_profile);
            post_image=itemView.findViewById(R.id.post_image);
            like=itemView.findViewById(R.id.like);
            comm=itemView.findViewById(R.id.com);
            save=itemView.findViewById(R.id.save);
            username=itemView.findViewById(R.id.username);
            likes=itemView.findViewById(R.id.likes);
            publisher=itemView.findViewById(R.id.publisher);
            description=itemView.findViewById(R.id.description);
            commnets=itemView.findViewById(R.id.comments);

        }

    }

    private void publisherInfo(final ImageView image_profile , final TextView username, final  TextView publisher , final String userid) {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference((String) User).child(userid);
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("UnsafeDynamicallyLoadedCode")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Glide.with(mContext).load((String) user.getImageurl()).into(image_profile);
                username.setText(user.getUsername());
                publisher.setText(user.getUsername());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            })
        }
    }
