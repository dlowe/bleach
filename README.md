# bleach

Whitens unsightly code.

## Installation

Add bleach to your project.clj file:

```clojure
    :dependencies [[bleach "0.0.11"]]
    :plugins [[bleach "0.0.11"]]
```

## Usage

You can bleach your code like this:

```bash
$ lein bleach src/helloworld/core.clj
```

When you bleach your code, it continues to work as it did before, only now it looks like:

```clojure
(use 'bleach.core) #bleach/ed "










"
```

## Acknowledgements

This is very much inspired by Damian Conway's Perl module
[Acme::Bleach](http://search.cpan.org/~dconway/Acme-Bleach-1.150/lib/Acme/Bleach.pm)

## License

Copyright © 2013 J. David Lowe

Distributed under the [Artistic License](http://dev.perl.org/licenses/artistic.html)
