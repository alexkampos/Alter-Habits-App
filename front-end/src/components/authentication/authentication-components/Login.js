import React, { useState, useRef } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import AuthService from "../../../services/auth-service";

const required = value => {
  if (!value) {
    return (
      <div className="required-alert-login" role="alert">
        This field is required!
      </div>
    );
  }
};

export default function Login(props) {
  const form = useRef();
  const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

  function onChangeUsername(e) {
    const username = e.target.value;
    setUsername(username);
  }

  function onChangePassword(e) {
    const password = e.target.value;
    setPassword(password);
  }

  function onClickForm(e) {
    e.stopPropagation()
  }

  const handleLogin = (e) => {
    e.preventDefault();

    setMessage("");
    setLoading(true);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      AuthService.login(username, password).then(
        () => {
          window.location.reload();
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          setLoading(false);
          setMessage(resMessage);
        }
      );
    } else {
      setLoading(false);
    }
  };


    return (
      <div className={props.customLoginStyle} onClick={onClickForm}>
          
          <Form
            onSubmit={handleLogin}
            ref={form}
          >
            <div className="user-pass-container">
              <Input
                type="text"
                className="text-inputs"
                placeholder="Username..."
                name="username"
                value={username}
                onChange={onChangeUsername}
                validations={[required]}
              />
            </div>

            <div className="user-pass-container">
              <Input
                type="password"
                className="text-inputs"
                placeholder="Password..."
                name="password"
                value={password}
                onChange={onChangePassword}
                validations={[required]}
              />
            </div>

            <div className="login-button-container">
              <button
                className=""
                disabled={loading}
              >
                {loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Login</span>
              </button>
            </div>

            {message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {message}
                </div>
              </div>
            )}
            <CheckButton
              style={{ display: "none" }}
              ref={checkBtn}
            />
          </Form>
      </div>
    );
  
}