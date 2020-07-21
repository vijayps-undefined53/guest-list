const arrivalsReducer = (arrivals = [], action) => {
  console.log(action.payload);
  switch (action.type) {
    case "arrivals":
      return action.payload;
    default:
      return [];
  }
};
export default arrivalsReducer;
