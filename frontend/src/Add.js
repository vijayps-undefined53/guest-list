import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Container, Col, Row, Form, FormGroup, Button } from "react-bootstrap";
import add_guest_action from "./Actions/add_guest_action";
import { connect } from "react-redux";
class Add extends Component {
  constructor(props) {
    super();
  }
  render() {
    return (
      <Container>
        {this.props.success ? (
          <div>
            <label>successfully saved</label>
            <Link to="/arrivals"> Add Guest </Link>
          </div>
        ) : (
          <Form>
            <FormGroup as={Row}>
              <FormGroup as={Col}>
                <Form.Label value="name">name</Form.Label>
                <Form.Control
                  type="text"
                  id="add-name"
                  placeholder={this.props.name}
                  contentEditable="true"
                ></Form.Control>
              </FormGroup>
              <FormGroup as={Col}>
                <Form.Label value="room type">room type</Form.Label>
                <Form.Control as="select" id="add-room-type">
                  <option>Deluxe</option>
                  <option>Honey Moon</option>
                  <option>Tree Top</option>
                </Form.Control>
              </FormGroup>
            </FormGroup>
            <FormGroup as={Row}>
              <FormGroup as={Col}>
                <Form.Label>address</Form.Label>
                <Form.Control
                  as="textarea"
                  id="add-address"
                  row={3}
                  placeholder={this.props.address}
                  contentEditable="true"
                ></Form.Control>
              </FormGroup>
              <FormGroup as={Col}>
                <Form.Label>email</Form.Label>
                <Form.Control
                  type="email"
                  id="add-email"
                  placeholder={
                    this.props.email
                      ? this.props.email
                      : "example_email@email.com (email validation in backend)"
                  }
                  contentEditable="true"
                ></Form.Control>
              </FormGroup>
            </FormGroup>
            <Button
              variant="primary"
              onClick={() => {
                this.props.add_guest_action(this.props.roomnumber);
              }}
            >
              submit
            </Button>
          </Form>
        )}
      </Container>
    );
  }
}
const mapStateToProps = state => {
  return { success: state.add_guest_reducer };
};
const mapDispatchToProps = () => {
  return { add_guest_action };
};
export default connect(mapStateToProps, mapDispatchToProps())(Add);
