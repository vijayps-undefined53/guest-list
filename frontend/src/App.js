import React, { useEffect, useState } from "react";
import "./App.css";
import {
  BrowserRouter as BR,
  Route as R,
  Switch,
  Link,
  useParams
} from "react-router-dom";
import {
  Container,
  Nav,
  Navbar,
  Jumbotron,
  Table,
  Col,
  Row,
  Form,
  FormGroup,
  Button
} from "react-bootstrap";
import GuestList from "./guestlist.js";
function Login() {
  let [loginstatus, setLoginstatus] = useState(false);
  let [username, setUsername] = useState("");
  let [pass, setPass] = useState("");
  useEffect(() => {
    s();
  });
  const s = async () => {
    let login = await fetch(
      `http://localhost:8080/login/?name=${username}&password=${pass}`
    )
      .then(res => res)
      .then(res => {
        if (res.status === 200) {
          setLoginstatus(true);
        } else {
          alert("Incorrect Password, check test db for configured password");
        }
      });
  };
  return (
    <React.Fragment>
      {!loginstatus ? (
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
                setUsername(document.getElementById("username").value);
                setPass(document.getElementById("password").value);
              }}
            >
              login
            </Button>
          </Form>
        </Container>
      ) : (
        <GuestList value={loginstatus}></GuestList>
      )}
    </React.Fragment>
  );
}
function App() {
  return (
    <React.Fragment>
      <BR>
        <Switch>
          <R exact path="/">
            <Login></Login>
          </R>
          <React.Fragment>
            <Navigation></Navigation>
            <Layout>
              <Switch>
                <R exact path={`/prepare`}>
                  <Jumbotr value={"prepare"}></Jumbotr>
                  <Prepare></Prepare>
                </R>
                <R exact path={`/arrivals`}>
                  <Jumbotr value={"arrivals"}></Jumbotr>
                  <Arrivals></Arrivals>
                </R>
                <R exact path={`/add`}>
                  <Jumbotr value={"add"}></Jumbotr>
                  <Add></Add>
                </R>
                <R exact path={`/updateguests/:roomnumber`}>
                  <Jumbotr value={"update"}></Jumbotr>
                  <UpdateGuests></UpdateGuests>
                </R>
                <R>
                  <NoMatch></NoMatch>
                </R>
              </Switch>
            </Layout>
          </React.Fragment>
        </Switch>
      </BR>
    </React.Fragment>
  );
}
const NoPage = () => (
  <div>
    Page not found for given path, use <Link to="/ ">/</Link> to login
  </div>
);
const Arrivals = () => {
  let [guests, setGuests] = useState([{}]);
  useEffect(() => {
    arrivals();
  }, []);
  let arrivals = async () => {
    await fetch(`http://localhost:8080/arrivals`)
      .then(res => res.json())
      .then(res => {
        setGuests(res);
      });
  };

  return (
    <Table striped bordered hover size="sm">
      <thead>
        <tr>
          <th>#</th>
          <th>Guest Name</th>
          <th>Room</th>
          <th>Update</th>
        </tr>
      </thead>
      <tbody>
        {guests.map((guest, i) => {
          return (
            <tr key={i}>
              <td>{i}</td>
              <td>{guest.name}</td>
              <td>{guest.room}</td>
              <td>
                <Link to={`updateguests/${guest.room}`}>Update Guest</Link>
              </td>
            </tr>
          );
        })}
      </tbody>
    </Table>
  );
};
export const Add = props => {
  let [success, setSuccess] = useState(false);
  let url = "";

  props.value === "update"
    ? (url = "http://localhost:8080/updateguests")
    : (url = "http://localhost:8080/addguests");
  return (
    <Container>
      {success ? (
        <div>
          <label>successfully saved</label>
          <Link to="/arrivals"> Add Guest </Link>
        </div>
      ) : (
        <Form>
          <FormGroup as={Row}>
            <FormGroup as={Col}>
              <Form.Label value="name">name</Form.Label>
              <Form.Control type="text" id="add-name"></Form.Control>
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
              ></Form.Control>
            </FormGroup>
            <FormGroup as={Col}>
              <Form.Label>email</Form.Label>
              <Form.Control type="email" id="add-email"></Form.Control>
            </FormGroup>
          </FormGroup>
          <Button
            variant="primary"
            onClick={() => {
              fetch(url, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                  name: document.getElementById("add-name").value,
                  roomType: document.getElementById("add-room-type").value,
                  address: document.getElementById("add-address").value,
                  email: document.getElementById("add-email").value,
                  room: props.roomnumber
                })
              }).then(res => {
                if (res.ok) {
                  setSuccess(true);
                }
              });
            }}
          >
            submit
          </Button>
        </Form>
      )}
    </Container>
  );
};
export const Prepare = () => <div>Prepare Tab </div>;
export const NoMatch = () => <div>Page not found for given path</div>;
export const NoLogin = () => <div>Not Logged In</div>;
export const UpdateGuests = props => {
  let { roomnumber } = useParams();
  return <Add value="update" roomnumber={roomnumber}></Add>;
};
export const Layout = props => <Container>{props.children}</Container>;
export const Navigation = props => {
  const styles = { color: "pink", backgroundColor: "grey" };
  let login = props.value;
  return { login } ? (
    <Navbar expand="lg" style={styles}>
      <Navbar.Brand href="/" style={styles}>
        Guest List
      </Navbar.Brand>
      <Navbar.Collapse>
        <Nav style={styles} className="ml-auto">
          <Nav.Item>
            <Nav.Link style={styles} href="/prepare">
              Prepare
            </Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link style={styles} href="/arrivals">
              Arrivals
            </Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link style={styles} href="/add">
              Add
            </Nav.Link>
          </Nav.Item>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  ) : (
    <NoLogin></NoLogin>
  );
};
export const Jumbotr = props => (
  <Jumbotron fluid className="Jumbotron">
    <div className="overlay"> </div>
    {props.value === "arrivals" ? (
      <Container>
        <h1>Guest List Arrivals</h1>
        <p>List of guests to check-in today</p>
      </Container>
    ) : props.value === "add" ? (
      <Container>
        <h1>Add Guest</h1>
        <p>Booking Room</p>
      </Container>
    ) : (
      <Container>
        <h1>Guest List Prepare</h1>
        <p>List of guests to check-in in future</p>
      </Container>
    )}
  </Jumbotron>
);

export default App;
