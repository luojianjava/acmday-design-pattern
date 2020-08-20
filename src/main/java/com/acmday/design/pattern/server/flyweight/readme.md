
## 享元模式
- 享元模式以共享的方式高效地支持大量的细粒度对象。享元对象能做到共享的关键是区分内蕴状态（Internal State）和外蕴状态（External State）。内蕴状态是存储在享元对象内部并且不会随环境改变而改变。因此内蕴状态并可以共享。

- 外蕴状态是随环境改变而改变的、不可以共享的状态。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态与内蕴状态是相互独立的。
- 享元模式可以分成单纯享元模式和复合享元模式两种形式。 

## 使用场景


## 故事背景
- 享元模式在编辑器系统中大量使用。一个文本编辑器往往会提供很多种字体，而通常的做法就是将每一个字母做成一个享元对象。享元对象的内蕴状态就是这个字母，而字母在文本中的位置和字模风格等其他信息则是外蕴状态。比如，字母a可能出现在文本的很多地方，虽然这些字母a的位置和字模风格不同，但是所有这些地方使用的都是同一个字母对象。这样一来，字母对象就可以在整个系统中共享。
