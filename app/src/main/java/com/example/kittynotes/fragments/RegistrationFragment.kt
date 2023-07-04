package com.example.kittynotes.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kittynotes.Domain.UseCase.RegistrationUseCase
import com.example.kittynotes.R
import com.example.kittynotes.Domain.dto.AuthRequest
import com.example.kittynotes.retrofit.ApiService
import com.example.kittynotes.retrofit.RequestExeption
import com.example.kittynotes.utils.InvalidUserData
import com.example.kittynotes.utils.Validator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegistrationFragment : Fragment() {
    private val registrationUseCase = RegistrationUseCase()

    private lateinit var view: View
    private lateinit var registrationBtn: Button
    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var repeatedPasswordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_registration, container, false)
        registrationBtn = view.findViewById(R.id.regitration_button)

        registrationBtn.setOnClickListener{
            onRegistrationClick(view)
        }

        return view
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

        try{
            registrationUseCase.execute(
                email = email,
                username = username,
                password = password,
                repeatedPassword = repeatedPassword
            )
            Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show()
        }
        catch (e: InvalidUserData){
            Toast.makeText(activity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
        catch (e: RequestExeption){
            Toast.makeText(activity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}