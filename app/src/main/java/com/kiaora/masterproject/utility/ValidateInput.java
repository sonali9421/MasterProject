package com.kiaora.masterproject.utility;

import android.text.InputFilter;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sonalilawande on 3/31/2018.
 */

public class ValidateInput {
    private static ValidateLog mLog;

    public static ValidateLog validateName(String name) {
        mLog = new ValidateLog();
        if (name.equals("")) {
            mLog.setMessage("Enter name.");
            mLog.setTag(0);
        } else if (name.matches(".*\\d+.*")) {
            mLog.setMessage("Check name characters.");
            mLog.setTag(0);
        } else if (name.length() < 2) {
            mLog.setMessage("Increase name length\\n(min 3 characters).");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    public static ValidateLog validateFullName(String fullName) {
        mLog = new ValidateLog();
        if (fullName.equals("")) {
            mLog.setMessage("Enter full name.");
            mLog.setTag(0);
        } else if (fullName.matches(".*\\d+.*")) {
            mLog.setMessage("Check full name characters.");
            mLog.setTag(0);
        } else if (!fullName.contains(" ")) {
            mLog.setMessage("Provide full name.");
            mLog.setTag(0);
        } else if (fullName.length() < 70) {
            mLog.setMessage("Increase full name length\\n(min 70 characters).");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    public static ValidateLog validateEmail(String email) {
        mLog = new ValidateLog();
        if (email.equals("")) {
            mLog.setMessage("Enter email.");
            mLog.setTag(0);
        } else if (!isValidEmail(email)) {
            mLog.setMessage("Check Email.");
            mLog.setTag(0);
        } else if (email.length() < 10) {
            mLog.setMessage("Increase email length\\n(min 10 characters).");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    public static ValidateLog validatePassword(String password) {
        mLog = new ValidateLog();

        if (password.equals("")) {
            mLog.setMessage("Enter password.");
            mLog.setTag(0);
        } else if (isValidPassword(password)) {
            mLog.setMessage("Check password. One capital letter, One digit, One symbol.");
            mLog.setTag(0);
        } else if (password.length() < 6) {
            mLog.setMessage("Increase password length\\n(min 6 characters).");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    public static ValidateLog validatePasswordMatch(String oldPassword, String newPassword) {
        mLog = new ValidateLog();
        if (oldPassword.equals("")) {
            mLog.setMessage("Enter password.");
            mLog.setTag(0);
        } else if (newPassword.equals("")) {
            mLog.setMessage("Enter confirm password.");
            mLog.setTag(0);
        } else if (isValidPassword(newPassword)) {
            mLog.setMessage("Check confirm password. One capital letter, One digit, One symbol.");
            mLog.setTag(0);
        } else if (newPassword.length() < 6) {
            mLog.setMessage("Increase confirm password length\\n(min 6 characters).");
            mLog.setTag(0);
        } else if (!oldPassword.equals(newPassword)) {
            mLog.setMessage("Password do't match.");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    public static ValidateLog validateContact(String contact) {
        mLog = new ValidateLog();
        if (contact.equals("")) {
            mLog.setMessage("Enter Contact Number.");
            mLog.setTag(0);
        } else if (contact.length() != 10) {
            mLog.setMessage("Check Contact Number.");
            mLog.setTag(0);
        } else if (isValidContact(contact)) {
            mLog.setMessage("Check Contact Number.");
            mLog.setTag(0);
        } else if (contact.equals("9876543210")) {
            mLog.setMessage("Non Existing vip contact number .");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
              /*  if (Integer.parseInt(contact.substring(0, 4)) < 6000) {
            mLog.setMessage("Non Existing contact number series.");
            mLog.setTag(0);
        }*/
        return mLog;
    }

    public static ValidateLog validateContactMatch(String newContact, String confirmContact) {
        mLog = new ValidateLog();
        if (confirmContact.equals("")) {
            mLog.setMessage("Enter confirm mobile Number.");
            mLog.setTag(0);
        } else if (newContact.equals("")) {
            mLog.setMessage("Enter new mobile Number.");
            mLog.setTag(0);
        } else if (confirmContact.length() < 10) {
            mLog.setMessage("Check confirm mobile Number.");
            mLog.setTag(0);
        } else if (isValidContact(newContact)) {
            mLog.setMessage("Check Contact Number.");
            mLog.setTag(0);
        } else if (confirmContact.equals("9876543210")) {
            mLog.setMessage("Non Existing vip confirm mobile number .");
            mLog.setTag(0);
        } else if (!newContact.equals(confirmContact)) {
            mLog.setMessage("Mobile number do't match.");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        /* if (Integer.parseInt(confirmContact.substring(0, 4)) < 6000) {
            mLog.setMessage("Non Existing confirm mobile number series.");
            mLog.setTag(0);
        }*/
        return mLog;
    }

    public static ValidateLog validateMessage(String message) {
        mLog = new ValidateLog();
        if (message.equals("")) {
            mLog.setMessage("Is empty.");
            mLog.setTag(0);
        } else {
            mLog.setMessage(null);
            mLog.setTag(1);
        }
        return mLog;
    }

    private static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private static boolean isValidPassword(String target) {
        String password_pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        if (target == null) {
            return false;
        } else {
            return target.matches(password_pattern);
        }
    }

    private static boolean isValidContact(String target) {
        String contact_pattern = "^[6-9]\\d{9}$";
        if (target == null) {
            return false;
        } else {
            return target.matches(contact_pattern);
        }
    }

    private static boolean isValidPhone(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.PHONE.matcher(target).matches();
        }
    }

    public static class ValidateLog {
        private String message;
        private int tag;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }


        public static void setEditTextMaxLength(final EditText editText, int length) {
            InputFilter[] FilterArray = new InputFilter[1];
            FilterArray[0] = new InputFilter.LengthFilter(length);
            editText.setFilters(FilterArray);
        }
    }

    public static boolean simpleTextValidate(EditText editText) {
        mLog = ValidateInput.validateMessage(editText.getText().toString());
        if (mLog.getTag() == 0) {
            editText.requestFocus();
            editText.setError(mLog.getMessage());
            return false;
        } else {
            editText.setError(mLog.getMessage());
            return true;
        }

    }

    public static boolean simpleTextValidate(TextView textView) {
        mLog = ValidateInput.validateMessage(textView.getText().toString());
        if (mLog.getTag() == 0) {
            textView.requestFocus();
            textView.setError(mLog.getMessage());
            return false;
        } else {
            textView.setError(mLog.getMessage());
            return true;
        }

    }

    public static boolean simpleEmailValidate(final EditText editText) {
        mLog = ValidateInput.validateEmail(editText.getText().toString());
        if (mLog.getTag() == 0) {
            editText.requestFocus();
            editText.setError(mLog.getMessage());
            return false;
        } else {
            editText.setError(mLog.getMessage());
            return true;
        }
    }
}
