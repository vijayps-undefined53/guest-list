const delete_guest_action = name => {
  console.log(name);
  return async dispatch => {
    let response = false;
    await fetch(`http://localhost:8080/deleteGuestByName?name=${name}`, {
      method: "DELETE"
    })
      .then(res => res)
      .then(res => (response = res.status === 200))
      .catch(error => console.log(error));
    dispatch({ type: "delete_guest_action", payload: response });
  };
};
export default delete_guest_action;
