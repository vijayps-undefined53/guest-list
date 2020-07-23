import React, { Component } from "react";
import { connect } from "react-redux";
import "./App.css";
import { Container, Row, Form, Button } from "react-bootstrap";
import GuestList from "./guestlist.js";
import { loginaction } from "./Actions/loginaction";
class Login extends Component {
  render() {
    return (
      <React.Fragment>
        {!this.props.login ? (
          <Container>
            <Form>
              <Form.Group as={Row}>
                <Form.Label>username</Form.Label>
                <Form.Control type="text" id="username"></Form.Control>
              </Form.Group>
              <Form.Group as={Row}>
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" id="password"></Form.Control>
              </Form.Group>
              <Button
                variant="primary"
                onClick={() => {
                  this.props.loginaction(
                    document.getElementById("username").value,
                    document.getElementById("password").value
                  );
                }}
              >
                login
              </Button>
            </Form>
          </Container>
        ) : (
          <GuestList value={this.props.login}></GuestList>
        )}
      </React.Fragment>
    );
  }
}

const mapStateToProps = state => {
  return {
    login: state.loginreducer
  };
};
const mapDispatchToProps = () => {
  return { loginaction };
};
export default connect(mapStateToProps, mapDispatchToProps())(Login);
