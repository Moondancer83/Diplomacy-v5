import Arrays from "./Arrays";

let array: number[];
let values: number[];

test("Arrays.containsAll should return true when array contains a single element", () => {
  array = [1, 2, 3, 4];
  values = [1];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeTruthy();
});

test("Arrays.containsAll should return true when array contains multiple elements", () => {
  array = [1, 2, 3, 4];
  values = [1, 2];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeTruthy();
});

test("Arrays.containsAll should return false when array does not contains a single element", () => {
  array = [1, 2, 3, 4];
  values = [5];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeFalsy();
});

test("Arrays.containsAll should return false when array does not contains a single element of multiple ones", () => {
  array = [1, 2, 3, 4];
  values = [1, 5];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeFalsy();
});

test("Arrays.containsAll should return false when array is empty", () => {
  array = [];
  values = [5];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeFalsy();
});

test("Arrays.containsAll should return true when no searched value presents", () => {
  array = [1];
  values = [];
  const actual = Arrays.containsAll(array, values);
  expect(actual).toBeTruthy();
});
