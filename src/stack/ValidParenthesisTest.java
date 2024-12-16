// package stack;

// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;


// class ValidParenthesisTest {

//     @Test
//     public void testEmptyString() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertTrue(vp.isValid(""), "An empty string should be valid.");
//     }

//     @Test
//     public void testSinglePair() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertTrue(vp.isValid("()"), "A single pair of parentheses should be valid.");
//         assertTrue(vp.isValid("{}"), "A single pair of curly braces should be valid.");
//         assertTrue(vp.isValid("[]"), "A single pair of square brackets should be valid.");
//     }

//     @Test
//     public void testNestedPairs() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertTrue(vp.isValid("([])"), "Nested pairs like ([]), should be valid.");
//         assertTrue(vp.isValid("{[()]}"), "Nested pairs like {[()]}, should be valid.");
//     }

//     @Test
//     public void testMultiplePairs() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertTrue(vp.isValid("()[]{}"), "Multiple consecutive pairs should be valid.");
//         assertTrue(vp.isValid("([]{})"), "Mixed nested pairs like ([]{}), should be valid.");
//     }

//     @Test
//     public void testInvalidSingleClose() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertFalse(vp.isValid(")"), "A single closing bracket without opening should be invalid.");
//     }

//     @Test
//     public void testMismatchedBrackets() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertFalse(vp.isValid("(]"), "Mismatched brackets (] should be invalid.");
//         assertFalse(vp.isValid("([)]"), "Incorrect order ([)] should be invalid.");
//     }

//     @Test
//     public void testExtraOpeningBracket() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertFalse(vp.isValid("({[)"), "Unclosed opening brackets ({[) should be invalid.");
//     }

//     @Test
//     public void testExtraClosingBracket() {
//         ValidParenthesis vp = new ValidParenthesis();
//         assertFalse(vp.isValid("{[]}])"), "Extra closing brackets {[]}]) should be invalid.");
//     }
// //    }
// }
