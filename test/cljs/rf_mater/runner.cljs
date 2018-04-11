(ns rf-mater.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [rf-mater.core-test]))

(doo-tests 'rf-mater.core-test)
