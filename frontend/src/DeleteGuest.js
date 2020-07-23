import React from "react";
import delete_guest_action from "./Actions/delete_guest_action";
import { connect } from "react-redux";
import { Link, Redirect } from "react-router-dom";
class DeleteGuest extends React.Component {
  componentDidMount() {
    this.props.delete_guest_action(this.props.name);
  }
  render() {
    return (
      <div>
        {this.props.deleted ? (
          <Redirect to={"/arrivals"} />
        ) : (
          <div>
            <label>Delete Unsuccessful , </label>
            <Link to="/arrivals"> Arrivals </Link>
          </div>
        )}
      </div>
    );
  }
}
const mapStateToProps = state => {
  return {
    deleted: state.delete_guest_reducer
  };
};
const mapDispatchToProps = () => {
  return { delete_guest_action };
};
export default connect(mapStateToProps, mapDispatchToProps())(DeleteGuest);
