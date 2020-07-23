const add_guest_action = roomnumber => {
  return async dispatch => {
    let response = false;
    console.log(roomnumber);
    roomnumber
      ? await fetch("http://localhost:8080/updateguests", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            name: document.getElementById("add-name").value,
            roomType: document.getElementById("add-room-type").value,
            address: document.getElementById("add-address").value,
            email: document.getElementById("add-email").value,
            room: roomnumber
          })
        })
          .then(res => res)
          .then(res => {
            console.log(res);
            response = res.status === 200;
          })
      : await fetch("http://localhost:8080/addguests", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            name: document.getElementById("add-name").value,
            roomType: document.getElementById("add-room-type").value,
            address: document.getElementById("add-address").value,
            email: document.getElementById("add-email").value
          })
        })
          .then(res => res)
          .then(res => {
            console.log(res);
            response = res.status === 200;
          });
    dispatch({ type: "add_guest_action", payload: response });
  };
};
export default add_guest_action;
