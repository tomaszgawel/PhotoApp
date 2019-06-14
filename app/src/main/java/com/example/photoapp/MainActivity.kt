package com.example.photoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.photoapp.core.components.DaggerMainActivityComponent
import com.example.photoapp.requests.ApiInterface
import com.example.photoapp.requests.callbacks.GetPhotoCallback
import com.example.photoapp.requests.models.PhotoModel
import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.photo)
    lateinit var photoView: CircleImageView

    @BindView(R.id.description)
    lateinit var descriptionView: TextView

    @Inject
    lateinit var eventbus: EventBus

    @Inject
    lateinit var retrofitService: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        DaggerMainActivityComponent.builder().build().inject(this)
        eventbus.register(EventListener())
        setupView()

    }

    fun setupView(){
        val call = retrofitService.getPhoto()
        call.enqueue(GetPhotoCallback(eventbus))
    }

    private inner class EventListener {

        @Subscribe
        fun handleEvent(event: PhotoModel) {

            descriptionView.text = event.description
            Picasso.get().load(event.photo).centerCrop().fit().into(photoView)

        }

    }
}
