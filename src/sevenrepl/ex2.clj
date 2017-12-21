(ns sevenrepl.ex2)

(def TODO "need to do this")

;; Return nil if "x" is not empty, otherwise return "Can't be empty"
(defn is-not-empty [x] TODO)
;
;; Return a function that evaluates whether or not its input is
;; at least the specified number of characters.
;; e.g. ((at-least-length 5) "foo") => "Must be at least 5 letters"
;; e.g. ((at-least-length 5) "foobar") => nil
;;
(defn at-least-length [min-length] TODO)
;
;; Return nil if not a valid phone number, or some truthy value if it is valid
;; (hint: look at re-matches)
(defn match-phone [phone] TODO)

;; Return nil if it's a valid phone number, or "Must be a valid phone number" if not
(defn valid-phone [phone] TODO)
;
;; Take a list of rules and apply all of them to the specified value. Return a list
;; of either error strings or nils for each rule.
;; (apply-rules (list is-not-empty (at-least-length 5)) "great") -> (nil nil)
;; (apply-rules (list is-not-empty (at-least-length 5)) "bad") -> (nil "Must be at least 5 letters")
;(defn apply-rules [rules value] TODO)
;
;; Remove nil values from the provided list.
;; e.g. (filter-nils (nil "foo" nil)) -> ("foo")
;(defn filter-nils [with-nils] TODO)
;
;; Tie it all together!
;; (validate-form form-rules good-form-data) => {:name (), :address (), :phone ()}
;; (validate-form form-rules bad-form-data) =>
;;   {:name ("Must be at least 5 letters"), :address ("Can't be empty"), :phone ("Must be a valid phone number")}

;(defn validate-form [all-rules form] TODO)

(def good-form-data
  {:name "Tony Arkles"
   :address "123 4th St"
   :phone "306-555-1212"})

(def bad-form-data
  {:name "Bob"
   :address ""
   :phone "306-555"})

(def form-rules
  {:name (list is-not-empty (at-least-length 5))
   :address (list not-empty)
   :phone (list valid-phone)})
