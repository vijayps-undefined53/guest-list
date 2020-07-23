import React from "react";
import "./App.css";
import Login from "./Login";
import Add from "./Add";
import Arrivals from "./Arrivals";
import DeleteGuest from "./DeleteGuest";
import {
  BrowserRouter as BR,
  Route as R,
  Switch,
  useParams
} from "react-router-dom";
import { Container, Nav, Navbar, Jumbotron } from "react-bootstrap";
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
                  <Add value="add"></Add>
                </R>
                <R
                  exact
                  path={`/updateguests/:roomnumber/:name/:address/:email`}
                >
                  <Jumbotr value={"update"}></Jumbotr>
                  <UpdateGuests></UpdateGuests>
                </R>
                <R exact path={`/deleteGuestByName/:name`}>
                  <Jumbotr value={"arrivals"}></Jumbotr>
                  <DeleteGuestsPasser></DeleteGuestsPasser>
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
export const Prepare = () => <div>Prepare Tab </div>;
export const NoMatch = () => <div>Page not found for given path</div>;
export const NoLogin = () => <div>Not Logged In</div>;
export const UpdateGuests = props => {
  let { roomnumber, name, address, email } = useParams();

  return (
    <Add
      value="update"
      roomnumber={roomnumber}
      name={name}
      address={address}
      email={email}
    ></Add>
  );
};
export const DeleteGuestsPasser = () => {
  let { name } = useParams();
  return <DeleteGuest name={name}></DeleteGuest>;
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
