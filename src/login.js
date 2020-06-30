import React, { useEffect, useState } from "react";
import "./App.css";
import GuestList from "./guestlist.js";
import { Container as C, Row, Col, Form, Button } from "react-bootstrap";
function Login() {
  let [loginstatus, setloginstatus] = useState(false);
  const user = document.getElementById("username");
  let username = "";
  let pass = "";
  if (user) {
    username = document.getElementById("username").value;
    pass = document.getElementById("password").value;
  }
  useEffect(() => {
    s();
  }, loginstatus);
  const s = async () => {
    let login = await fetch(
      `http://localhost:8080/login/?name=${username}&password=${pass}`
    );
    let status = await login.status;
    setloginstatus(status === 200);
    console.log(loginstatus);
  };
  return (
    <React.Fragment>
      {!loginstatus ? (
        <C>
          <Form>
            <Form.Group as={Row}>
              <Form.Label>username</Form.Label>
              <Form.Control type="text" id="username"></Form.Control>
            </Form.Group>
            <Form.Group as={Row}>
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" id="password"></Form.Control>
            </Form.Group>
            <Button type="submit" onClick={() => setloginstatus(true)}>
              login
            </Button>
          </Form>
        </C>
      ) : (
        <GuestList value={loginstatus}></GuestList>
      )}
    </React.Fragment>
  );
}

export default Login;
