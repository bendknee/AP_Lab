# Exercise 2: Factory Method & Singleton Pattern

CSCM602023 - Advanced Programming (Pemrograman Lanjut) @ Faculty of
Computer Science Universitas Indonesia, Even Semester 2016/2017

* * *

You are given with an exercises about Singleton Pattern, follow the exercises and understand how these method works.
Then, you are given a program that using no pattern in its form creation functionality. You are asked to exercise your understanding in Factory Method Pattern and Singleton Pattern by *refactoring* the program.  Refactoring means restructuring existing code without changing its functionalities to improve the design of code.

For lab exercise monitoring purpose, you are asked to frequently add & commit your
code, e.g. everytime you completed a task item, everytime you added a class or
function.

* * *

## Exercises

The Singleton Pattern is used when we need a class that has only a single
instance that is the one and only instance accessed throughout the program. For example, when we want to create a program that set 'rates' we understand that 'rates' only binds into one object. Because of that using singleton pattern would be the right way in creating the object.

Let us study how to make a singleton pattern. Make a program like this and save it within `SingletonPattern.py`:

```
class OnlyOne:
    class __OnlyOne:
        def __init__(self, arg):
            self.val = arg
        def __str__(self):
            return repr(self) + self.val
    instance = None
    def __init__(self, arg):
        if not OnlyOne.instance:
            OnlyOne.instance = OnlyOne.__OnlyOne(arg)
        else:
            OnlyOne.instance.val = arg
    def __getattr__(self, name):
        return getattr(self.instance, name)
```

Please take look at the program, the first time you create an OnlyOne, it initializes instance, but after that it just ignores you. Add the codes below to the current program:

```
x = OnlyOne('sausage')
print(x)
print(x.instance)
print()
y = OnlyOne('eggs')
print(y)
print(y.instance)
print()
z = OnlyOne('spam')
print(z)
print(z.instance)
print()

print('Kembali melihat object x')
print(x)
print(x.instance)
print()

print('Kembali melihat object y')
print(y)
print(y.instance)
print()
```

Execute the program and the program should have an output like this:

```
inisiasi sebuah instance
<__main__.OnlyOne object at 0x0278F4D0>sausage
<__main__.OnlyOne.__OnlyOne object at 0x0277E9F0>sausage

update di instance yang sama
<__main__.OnlyOne object at 0x0277EA10>eggs
<__main__.OnlyOne.__OnlyOne object at 0x0277E9F0>eggs

update di instance yang sama
<__main__.OnlyOne object at 0x02813470>spam
<__main__.OnlyOne.__OnlyOne object at 0x0277E9F0>spam

Kembali melihat object x
<__main__.OnlyOne object at 0x0278F4D0>spam
<__main__.OnlyOne.__OnlyOne object at 0x0277E9F0>spam

Kembali melihat object y
<__main__.OnlyOne object at 0x0277EA10>spam
<__main__.OnlyOne.__OnlyOne object at 0x0277E9F0>spam
```

Take a look at the output above, you can see from the output that even though it appears that multiple objects have been created, the same `__OnlyOne` object is used for both. The instances of `OnlyOne` are distinct but they all proxy to the same `__OnlyOne` object.

Note that the above approach doesn�t restrict you to creating only one object. This is also a technique to create a limited pool of objects. In that situation, however, you can be confronted with the problem of sharing objects in the pool. If this is an issue, you can create a solution involving a check-out and check- in of the shared objects.

A variation on this technique uses the class method __new__ added in Python 2.2, write it in `NewSingleton.py`:

```
class OnlyOne(object):
    class __OnlyOne:
        def __init__(self):
            self.val = None
        def __str__(self):
            return repr(self) + self.val
    instance = None
    def __new__(cls): # __new__ always a classmethod
        if not OnlyOne.instance:
            OnlyOne.instance = OnlyOne.__OnlyOne()
        return OnlyOne.instance
    def __getattr__(self, name):
        return getattr(self.instance, name)
	def __setattr__(self, name):
		return setattr(self.instance, name)

x = OnlyOne()
x.val = 'sausage'
print(x)
y = OnlyOne()
y.val = 'eggs'
print(y)
z = OnlyOne()
z.val = 'spam'
print(z)
print(x)
print(y)
```

Execute the program and it should have an output like this:

```
<__main__.OnlyOne.__OnlyOne object at 0x0290B510>sausage
<__main__.OnlyOne.__OnlyOne object at 0x0290B510>eggs
<__main__.OnlyOne.__OnlyOne object at 0x0290B510>spam
<__main__.OnlyOne.__OnlyOne object at 0x0290B510>spam
<__main__.OnlyOne.__OnlyOne object at 0x0290B510>spam
```

One more technique that you could use to create Singleton pattern is a technique that Alex Martelli created, Borg. The name Borg was taken from Star Trek:The Next Generation character, he was famous for his quotes "We are all one". Because of that, Borg was taken to represent Singleton pattern technique. Borg is accomplished by setting all the `__dict__s` to the same static piece of storage. With this could create as many object as you want as long as they refer to one information state. The fundamental differences between Singleton and Borg, Borg is a pool of objects referring to a shared state and Singleton is just one object. How to create Borg will be like this, write it in `BorgSingleton.py`:

```
class Borg:
    _shared_state = {}
    def __init__(self):
        self.__dict__ = self._shared_state

class Singleton(Borg):
    def __init__(self, arg):
        Borg.__init__(self)
        self.val = arg
    def __str__(self): return self.val
x = Singleton('sausage')
print(x)
y = Singleton('eggs')
print(y)
z = Singleton('spam')
print(z)
print(x)
print(y)
print(repr(x))
print(repr(y))
print(repr(z))
```

Execute the program and it should have an output like this:

```
sausage
eggs
spam
spam
spam
<__main__.Singleton object at 0x028034D0>
<__main__.Singleton object at 0x027F29F0>
<__main__.Singleton object at 0x027F2A10>
```

This has an identical effect as SingletonPattern.py does, but it�s more elegant. In the former case, you must wire in Singleton behavior to each of your classes, but Borg is designed to be easily reused through inheritance.


## Mandatory Checklist

- [ ] Put your work in separate branch named `lab-week-2`
    - Hint: `git checkout -b lab-week-2`
- [ ] Create folder named `factory-method-pattern`. Save all the file from mandatory checklist number 3 and additional checklist number 1-2 in this folder.
	- Hint: `mkdir factory-method-pattern`
- [ ] From `Tutorial2-FM-Template.py` refactor the program by using factory method pattern. Ensures the program has the same output.
	- [ ] Save it in `Tutorial2-FM.py`
	- [ ] Commit with a representative comment
- [ ] Create folder named `singleton-pattern`. Save all the file from mandatory checklist number 5-10 and additional checklist number 3 in this folder.
	- Hint: `mkdir singleton-pattern`
- [ ] Create `SingletonPattern.py` based on the exercises. Ensures that the output is not much different from the output in file exercises.
    - [ ] Commit with a representative comment
- [ ] Create `NewSingleton.py` based on the exercises. Ensures that the output is not much different from the output in file exercises.
    - [ ] Commit with a representative comment
- [ ] Create `BorgSingleton.py` based on the exercises. Ensures that the output is not much different from the output in file exercises.
    - [ ] Commit with a representative comment
- [ ] Explain the difference between `SingletonPattern.py` and `NewSingleton.py`. Write it on a file named `SingletonVsNewSingleton.txt`.
	- [ ] Commit with a representative comment
- [ ] From `Tutorial2-S.py` create IdnCurrRates to become a Singleton with using the same technique as `NewSingleton.py`.
	- [ ] Save your work in `Tutorial2Singleton.py`
	- [ ] Commit with a representative comment
- [ ] From `Tutorial2-S.py` use class Borg for the Singleton pattern. (Don't continue from mandatory checklist No.12, edit from a brand new `Tutorial2-S.py`)
	- [ ] Create new class named `SgprCurrRates`
	- [ ] Uncomment codes for Mandatory Checklist no.13
	- [ ] Commit with a representative comment
- [ ] Push your work to your GitLab repository
    - Hint: `git push -u origin lab-week-2`
    - You can do this earlier, i.e. after finished task no. 2, but ensure that
    the final result of your work is pushed before the tutorial ends!

## Additional Checklist

- [ ] Create `Tutorial2-FM-Basic.py` to have a Board with nxn size. Then, revised the output so it could have "xoxoxo..." pattern on the odd lines and it could have "uvuvuv..." on the even lines.
    - [ ] Save your work in `Tutorial2-FM-Dynamic.py`
	- [ ] Commit with a representative comment
- [ ] Write a brief explanation about the difference between `gameboard1.py`, `gameboard2.py`, `gameboard3.py`, and `gameboard4.py`. Write it in `factoryMethodPattern.txt`
	- [ ] Commit with a representative comment
- [ ] Refactor `BorgSingleton.py` using __new__ method (the same technique as NewSingleton.py.
	- [ ] Save your work in `NewBorg.py`
	- [ ] Commit with a representative comment
	
## References

[1] For Factory Method Pattern: Python in Practice page 17-24.
[1] For Singleton Pattern: http://python-3-patterns-idioms-test.readthedocs.io/en/latest/Singleton.html