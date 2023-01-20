package com.example.salt.qrapp;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by SALT on 1/31/2017.
 */
public class RegisterActivity extends AppCompatActivity
{

    Bitmap FixBitmap;
    Button login;
    ImageButton addphoto, showSelectedImage;
    Context c;
    EditText firstname, lastname, mobileNumber, province, address, emailAddress, password;
    @Override
    protected  void onCreate (Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        c=this;

        firstname = (EditText) findViewById (R.id.etFirstName);
        lastname = (EditText) findViewById (R.id.etLastName);
        mobileNumber = (EditText) findViewById (R.id.etMobileNumber);
        province = (EditText) findViewById (R.id.etProvince);
        address = (EditText) findViewById (R.id.etAddress);
        emailAddress = (EditText) findViewById (R.id.etEmailAddress);
        password = (EditText) findViewById (R.id.rtPassword);
        addphoto = (ImageButton) findViewById(R.id.addPhotoButton);
        showSelectedImage = (ImageButton) findViewById(R.id.addPhotoButton) ;

        addphoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select Image From Gallery"), 1);

            }
        });



        login = (Button) findViewById(R.id.login);
       // login.setOnClickListener(new View.OnClickListener()
      //  {
         //   @Override
          //  public void onClick(View view)
          //  {
            //    explodeTransitionByCode(view);
                //Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
               // startActivity(i);
          //  }
        //});
    }

    @Override
    protected void onActivityResult(int RC, int RQC, Intent I)
    {

        super.onActivityResult(RC, RQC, I);

        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null)
        {

            Uri uri = I.getData();

            try
            {


                FixBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                Drawable drawable = new BitmapDrawable(FixBitmap);
                showSelectedImage.setBackgroundDrawable(drawable);

                //showSelectedImage.setImageBitmap(FixBitmap);

            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
        }
    }


    public void onReg (View view)
        {
            String str_firstname = firstname.getText().toString();
            String str_lastname = lastname.getText().toString();
            String str_mobileNumber = mobileNumber.getText().toString();
            String str_province = province.getText().toString();
            String str_address = address.getText().toString();
            String str_emailAddress = emailAddress.getText().toString();
            String str_password = password.getText().toString();
            String type = "register";


            if (str_firstname.length() == 0 && str_password.length() == 0 && str_lastname.length() == 0  && str_mobileNumber.length() < 11
                    && str_province.length() == 0 && str_emailAddress.length()==0)
            {
                Toast.makeText(c,"All fields cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;
            }
            else if(str_firstname.length() == 0 && (str_password.length() != 0 || str_lastname.length() != 0  || str_mobileNumber.length() == 11
                    || str_province.length()!= 0 || str_emailAddress.length()!=0))
            {
                Toast.makeText(c,"First name cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;

            }
            else if ((str_firstname.length() != 0) && str_password.length() == 0 && (str_lastname.length() != 0  || str_mobileNumber.length() > 10
                    || str_province.length() != 0 || str_emailAddress.length()!=0))
            {
                Toast.makeText(c,"Password cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;
            }
            else if ((str_firstname.length() != 0 || str_password.length() != 0) && str_lastname.length() == 0 && ( str_mobileNumber.length() > 10
                    || str_province.length() != 0 || str_emailAddress.length()!=0))
            {
                Toast.makeText(c,"Last name cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;
            }
            else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0) && str_address.length()==0 && (str_mobileNumber.length() > 10
                    || str_province.length() != 0 || str_emailAddress.length()!=0))
            {
                Toast.makeText(c,"Sorry Your Address cannot be left blank", Toast.LENGTH_LONG) .show();
                return;
            }
            else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length()!=0) && str_mobileNumber.length() < 11
                    && (str_province.length() != 0 || str_emailAddress.length()!=0))
            {
                Toast.makeText(c,"Warning!! Your phone number cannot be less than 11 digits", Toast.LENGTH_LONG) .show();
                return;
            }
            else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length() !=0 || str_mobileNumber.length() >10
            )&& str_province.length() == 0 && (str_emailAddress.length()>0))
            {
                Toast.makeText(c,"Province field cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;
            }
            else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length() !=0 || str_mobileNumber.length() >10
                    || str_province.length() != 0) && str_emailAddress.length()==0)
            {
                Toast.makeText(c,"Your EmailAddress cannot be left blank!", Toast.LENGTH_LONG) .show();
                return;
            }
            else
            {

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);

               /* SignInBackgroundWorker signInBackgroundWorker = new SignInBackgroundWorker(this);
                signInBackgroundWorker.execute(type, str_name, str_surname, str_age, str_mobileNumber, str_course, str_courseRegisterationNumber,
                        str_emailAddress, str_password);*/

            }

        }

    @TargetApi(21)
    public void explodeTransitionByCode(View view)
    {
        String str_firstname = firstname.getText().toString();
        String str_lastname = lastname.getText().toString();
        String str_mobileNumber = mobileNumber.getText().toString();
        String str_province = province.getText().toString();
        String str_address = address.getText().toString();
        String str_emailAddress = emailAddress.getText().toString();
        String str_password = password.getText().toString();
        String type = "register";


        if (str_firstname.length() == 0 && str_password.length() == 0 && str_lastname.length() == 0  && str_mobileNumber.length() < 11
                && str_province.length() == 0 && str_emailAddress.length()==0)
        {
            Toast.makeText(c,"All fields cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;
        }
        else if(str_firstname.length() == 0 && (str_password.length() != 0 || str_lastname.length() != 0  || str_mobileNumber.length() == 11
                || str_province.length()!= 0 || str_emailAddress.length()!=0))
        {
            Toast.makeText(c,"First name cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;

        }
        else if ((str_firstname.length() != 0) && str_password.length() == 0 && (str_lastname.length() != 0  || str_mobileNumber.length() > 10
                || str_province.length() != 0 || str_emailAddress.length()!=0))
        {
            Toast.makeText(c,"Password cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;
        }
        else if ((str_firstname.length() != 0 || str_password.length() != 0) && str_lastname.length() == 0 && ( str_mobileNumber.length() > 10
                || str_province.length() != 0 || str_emailAddress.length()!=0))
        {
            Toast.makeText(c,"Last name cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;
        }
        else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0) && str_address.length()==0 && (str_mobileNumber.length() > 10
                || str_province.length() != 0 || str_emailAddress.length()!=0))
        {
            Toast.makeText(c,"Sorry Your Address cannot be left blank", Toast.LENGTH_LONG) .show();
            return;
        }
        else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length()!=0) && str_mobileNumber.length() < 11
                && (str_province.length() != 0 || str_emailAddress.length()!=0))
        {
            Toast.makeText(c,"Warning!! Your phone number cannot be less than 11 digits", Toast.LENGTH_LONG) .show();
            return;
        }
        else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length() !=0 || str_mobileNumber.length() >10
        )&& str_province.length() == 0 && (str_emailAddress.length()>0))
        {
            Toast.makeText(c,"Province field cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;
        }
        else if ((str_firstname.length() != 0 || str_password.length() != 0 || str_lastname.length() != 0 || str_address.length() !=0 || str_mobileNumber.length() >10
                || str_province.length() != 0) && str_emailAddress.length()==0)
        {
            Toast.makeText(c,"Your EmailAddress cannot be left blank!", Toast.LENGTH_LONG) .show();
            return;
        }
        else {

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
            i.putExtra(Constants.KEY_TITLE, "Explode Test");
            startActivity(i, options.toBundle());
        }
    }

    @TargetApi(21)
    public void explodeTransitionByXML(View view)
    {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        i.putExtra(Constants.KEY_TITLE, "Explode XML");
        startActivity(i, options.toBundle());
    }

    }

