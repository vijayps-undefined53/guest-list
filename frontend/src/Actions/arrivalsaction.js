export const arrivalsaction = () => {
  return async dispatch => {
    let arrivals = [];
    await fetch(`http://localhost:8080/arrivals`)
      .then(res => res.json())
      .then(res => {
        arrivals = res;
      })
      .catch(error => console.log(error));
    dispatch({ type: "arrivals", payload: arrivals });
  };
};
