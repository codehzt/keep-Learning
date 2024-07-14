# C++学习笔记

## std::function

`std::function`是C++标准库中的一个类模板，用于存储和调用可调用对象，如函数、lambda表达式、函数对象（functor）和成员函数等。它是C++11引入的强大工具，使得函数对象的使用更加灵活和安全。

### 使用`std::function`

#### 引入头文件

首先需要包含头文件：

```
cpp
复制代码
#include <functional>
```

#### 定义和使用`std::function`

1. **存储普通函数**：

   ```
   cpp复制代码#include <iostream>
   #include <functional>
   
   int add(int a, int b) {
       return a + b;
   }
   
   int main() {
       std::function<int(int, int)> func = add;
       std::cout << "Result: " << func(2, 3) << std::endl;  // 输出: Result: 5
       return 0;
   }
   ```

2. **存储lambda表达式**：

   ```
   cpp复制代码#include <iostream>
   #include <functional>
   
   int main() {
       std::function<int(int, int)> func = [](int a, int b) {
           return a + b;
       };
       std::cout << "Result: " << func(2, 3) << std::endl;  // 输出: Result: 5
       return 0;
   }
   ```

3. **存储函数对象（functor）**：

   ```
   cpp复制代码#include <iostream>
   #include <functional>
   
   struct Add {
       int operator()(int a, int b) const {
           return a + b;
       }
   };
   
   int main() {
       std::function<int(int, int)> func = Add();
       std::cout << "Result: " << func(2, 3) << std::endl;  // 输出: Result: 5
       return 0;
   }
   ```

4. **存储成员函数**：

   ```
   cpp复制代码#include <iostream>
   #include <functional>
   
   struct Calculator {
       int add(int a, int b) {
           return a + b;
       }
   };
   
   int main() {
       Calculator calc;
       std::function<int(Calculator&, int, int)> func = &Calculator::add;
       std::cout << "Result: " << func(calc, 2, 3) << std::endl;  // 输出: Result: 5
       return 0;
   }
   ```

### 优点

- **类型安全**：`std::function`提供类型安全的可调用对象存储和调用。
- **灵活性**：它可以存储各种类型的可调用对象，使得代码更加灵活。
- **简洁**：简化了代码的编写和阅读，提高了代码的可维护性。

### 性能注意事项

尽管`std::function`非常强大和灵活，但它在某些情况下可能会带来额外的开销。尤其是在性能要求非常高的场合，使用`std::function`可能会引入不必要的间接调用开销。对于性能敏感的代码，直接使用函数指针或内联lambda表达式可能会更高效。

总结起来，`std::function`是C++中用于管理和调用可调用对象的强大工具，它使得编写灵活、可维护的代码更加容易。如果你有更多具体的使用场景或问题，请告诉我，我可以提供更详细的解释和示例。