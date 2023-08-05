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
import com.example.kittynotes.R
import com.example.kittynotes.domain.dto.responses.JwtResponse
import com.example.kittynotes.domain.useCase.UsernameSingInUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UsernameSignInFragment : Fragment() {
    private val usernameSingInUseCase = UsernameSingInUseCase()

    private lateinit var view: View
    private lateinit var signInBtn: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var toEmailSingInBtn: TextView
    private lateinit var toRegistrationBtn: TextView
    private var jwtToken: JwtResponse? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view = inflater.inflate(R.layout.fragment_username_sign_in, container, false)

        toRegistrationBtn = view.findViewById(R.id.to_registration)
        toRegistrationBtn.setOnClickListener {
            toRegistrationPage()
        }

        toEmailSingInBtn = view.findViewById(R.id.to_email_sing_in)
        toEmailSingInBtn.setOnClickListener {
            toLogInByEmailPage()
        }

        signInBtn = view.findViewById(R.id.sign_in_button)
        signInBtn.setOnClickListener {
            onSignInClick()
        }

        return view
    }

    private fun toLogInByEmailPage(){
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, EmailSignInFragment()).commit()
    }

    private fun toRegistrationPage(){
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, RegistrationFragment()).commit()
    }

    private fun onSignInClick() {
        usernameEditText = view.findViewById(R.id.username_edit_text)
        passwordEditText = view.findViewById(R.id.password_edit_text)


        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(activity, throwable.message, Toast.LENGTH_SHORT).show()
            }
        }

        CoroutineScope(handler).launch {
            jwtToken = async {
                usernameSingInUseCase.execute(
                    username = usernameEditText.text.toString(),
                    password = passwordEditText.text.toString()
                )
            }.await()

        }
    }

}