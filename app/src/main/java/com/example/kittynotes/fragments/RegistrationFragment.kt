package com.example.kittynotes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kittynotes.domain.useCase.RegistrationUseCase
import com.example.kittynotes.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class RegistrationFragment : Fragment() {
    private val registrationUseCase = RegistrationUseCase()

    private lateinit var view: View
    private lateinit var registrationBtn: Button
    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var repeatedPasswordEditText: EditText
    private lateinit var toSingInBtn: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_registration, container, false)

        registrationBtn = view.findViewById(R.id.regitration_button)
        registrationBtn.setOnClickListener{
            onRegistrationClick(view)
        }

        toSingInBtn = view.findViewById(R.id.to_sing_in)
        toSingInBtn.setOnClickListener {
            toSingInPage(view)
        }

        return view
    }

    private fun toSingInPage(view:View){
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, UsernameSignInFragment()).commit()
    }

    private fun onRegistrationClick(view: View){
        emailEditText = view.findViewById(R.id.email_edit_text)
        usernameEditText = view.findViewById(R.id.username_edit_text)
        passwordEditText = view.findViewById(R.id.password_edit_text)
        repeatedPasswordEditText = view.findViewById(R.id.repeat_password_edit_text)

        val email = emailEditText.text.toString()
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val repeatedPassword = repeatedPasswordEditText.text.toString()

        //Toast.makeText(activity, e.message.toString(), Toast.LENGTH_SHORT).show()

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(activity, throwable.message, Toast.LENGTH_SHORT).show()
            }
        }

        CoroutineScope(handler).launch {
            registrationUseCase.execute(
                email = email,
                username = username,
                password = password,
                repeatedPassword = repeatedPassword
            )

            MainScope().launch {
                Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show()
            }

        }
    }


}