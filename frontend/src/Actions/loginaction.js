export const loginaction = (username, password) => {
  return async dispatch => {
    let response = await fetch(
      `http://localhost:8080/login/?name=${username}&password=${password}`
    );
    dispatch({ type: "login", payload: response });
  };
};
