package com.briannur_18104006.commerc.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.briannur_18104006.commerc.R
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    private lateinit var settingViewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel =
                ViewModelProvider(this).get(SettingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_setting, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cur_user.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) cur_user.setHint(
                ""
            ) else cur_user.setHint("Username")
        })

        cur_mail.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) cur_mail.setHint(
                ""
            ) else cur_mail.setHint("Email")
        })

        cur_pass.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) cur_pass.setHint(
                ""
            ) else cur_pass.setHint("Password")
        })
    }
}