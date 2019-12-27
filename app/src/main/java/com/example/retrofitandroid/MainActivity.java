package com.example.retrofitandroid;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.telecom.Call;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_insta.R;
import com.example.retrofitandroid.Models.Comment;
import com.example.retrofitandroid.Models.PostModel;
import com.example.retrofitandroid.Service.PostService;
import com.google.android.gms.common.api.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    JasonPlaceHolderApi jasonPlaceHolderApi=retrofit.create(JasonPlaceHolderApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        Gson gson=new GsonBuilder().serializeNulls().create();

        ScriptGroup.Builder retrofit = null;
        jasonPlaceHolderApi = retrofit.create(JasonPlaceHolderApi.class);
        getPosts();
        getComments();
        createPost();
        updatePost();
    }

    private void updatePost() {
        PostModel postModelRequest = new PostModel("text", "Username", "100");
        Call<PostModel> call = jsonPlaceHolderApli.putPost();
        @Override
                getPostsModel.enqueue(new Callback<PostModel>() {
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                PostModel postResponse = response.body();

                for (PostModel post : posts) {
                    String content = "";
                    content += "code: " + response.code() + "\n";
                    content += "ID: " + postResponse.getId() + "\n";
                    content += "Comm: " + postResponse.getComment() + "\n";
                    content += "Photo: " + postResponse.getPhoto() + "\n";
                    content += "UserName: " + postResponse.getUserName() + "\n";
                    content += "Avatar: " + postResponse.getUserAvatar() + "\n";
                    content += "CreatedAt: " + postResponse.getCreatedAt() + "\n";

                    textViewResult.setText(content);
                }
            }

            @Override
            public void OnFailure(Call<PostModel> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }
    private void getPosts() {
        PostModel postModelRequest = new PostModel("text","Username","100");

        Map<String, String> parameters =new HashMap<>();
        ((HashMap) parameters).put("body" , "text");
        ((HashMap) parameters).put("userName" , "userName");
        ((HashMap) parameters).put("likes" , "100");

        Call<PostModel> call = jasonPlaceHolderApi.getPosts(parameters);
        PostService.initalizeRetrofit();
        Call<PostModel> getPostsModel = PostService._postService.createPost(postModelRequest);

        getPostsModel.enqueue(new Callback<PostModel>() {
            public void onResponse(Call<PostModel> call, Response<PostModel> response, Object posts) {
                PostModel postModelResponse = response.body(); }
                if(!response.isSuccessful()){
                textViewResult.setText("Code: " + response.code());
                return;
            }

            List<PostModel> posts=response.body();

                for(PostModel post: posts) {
                String content="";
                content+="ID: " + post.getId() + "\n";
                content+="Comm: " + post.getComment() + "\n";
                content+="Photo: " + post.getPhoto() + "\n";
                content+="UserName: " + post.getUserName() + "\n";
                content+="Avatar: " + post.getUserAvatar() + "\n";
                content+="CreatedAt: " + post.getCreatedAt() + "\n";

                textViewResult.append(content);
            }
        }

        @Override
        public void onFailure(Call<PostModel> call, Throwable t) {
            textViewResult.setText(t.getMessage());
        }
    });
}

    private void getComments(){
        int url;
        Call<Comment> call = jasonPlaceHolderApi.getComment(url: "posts/3/comment");
        Comment commentRequest = new Comment("bla bla");

        CommService.initalizeRetrofit();

        Call<Comment> getComment = CommService._commentService.createComment(commentRequest);

        getComment.enqueue(new Callback<Comment>() {
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Comment ComentResponse = response.body();
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;;
                }
                List<Comment> comments=response.body();

                for(Comment comment: comments) {
                    String content="";
                    content+="ID: " + comment.getId() + "\n";
                    content+="ID: " + comment.getPostId() + "\n";
                    content+="Comm: " + comment.getComments() + "\n";
                    content+="UserName: " + comment.getUserName() + "\n";
                    content+="Avatar: " + comment.getUserAvatar() + "\n";
                    content+="CreatedAt: " + comment.getCreatedAt() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
    private void createPost() {
        PostModel post =new PostModel("new username","230");
        Map<String,String>fields=new HashMap<>();
        fields.put("userName" , "UserName");
        fields.put("likes" , "230");

        Call<PostModel> call=jasonPlaceHolderApi.createPost(fields);

        getPostsModel.enqueue(new Callback<PostModel>() {
            public void onResponse(Call<PostModel> call, Response<PostModel> response, Object posts) {
                PostModel postModelResponse = response.body();
            }
                if(!response.isSuccessful())

            {
                textViewResult.setText("Code: " + response.code());
                return;
            }

            PostModel postResponse = response.body();

                for(PostModel post:posts)

            {
                String content = "";
                content += "code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "Comm: " + postResponse.getComment() + "\n";
                content += "Photo: " + postResponse.getPhoto() + "\n";
                content += "UserName: " + postResponse.getUserName() + "\n";
                content += "Avatar: " + postResponse.getUserAvatar() + "\n";
                content += "CreatedAt: " + postResponse.getCreatedAt() + "\n";

                textViewResult.setText(content);
            }
        }

        @Override
        public void onFailure(Call<PostModel> call, Throwable Throwable t); {
            textViewResult.setText(t.getMessage());
        }
    });
}
