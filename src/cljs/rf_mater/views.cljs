(ns rf-mater.views
  (:require [re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
            [rf-mater.events :as events]
            ;; [cljsjs.material-ui]
            ;; [cljs-react-material-ui.core :refer [get-mui-theme color]]
            ;; [cljs-react-material-ui.reagent :as ui]
            ;; [cljs-react-material-ui.icons :as ic]
            ;; [garden.core :refer [css]]
            [reagent.core :as r]
          ;;["" :default ]
            ;
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Avatar" :default Avatar]

            ["@material-ui/core/Button" :default Button]

            ["@material-ui/core/Card" :default Card]
            ["@material-ui/core/CardActions" :default CardActions]
            ["@material-ui/core/CardContent" :default CardContent]
            ["@material-ui/core/CardMedia" :default CardMedia]
            ["@material-ui/core/CardHeader" :default CardHeader]
            ["@material-ui/core/Collapse" :default Collapse]

            ["@material-ui/core/Divider" :default Divider]

            ["@material-ui/core/Grid" :default Grid]

            ["@material-ui/core/Hidden" :default Hidden]

            ["@material-ui/core/Paper" :default Paper]

            ["@material-ui/core/IconButton" :default IconButton]

            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/TextField" :default TextField]

            ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]

            ["@material-ui/icons/Favorite" :default FavoriteIcon]
            ["@material-ui/icons/Share" :default ShareIcon]
            ["@material-ui/icons/ExpandMore" :default ExpandMoreIcon]
            ["@material-ui/icons/MoreVert" :default MoreVertIcon]
            ["@material-ui/icons/Menu" :default MenuIcon]
            ["@material-ui/icons/HelpOutline" :default HelpOutlineIcon]))

;;
(def theme (createMuiTheme #js {}))
(def set-new-font
  "\"-apple-system\", \"BlinkMacSystemFont\", \"Segoe UI\",\"Roboto\",  \"Helvetica Neue\", \"Arial\", \"sans-serif\", \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\"")

(set! (-> theme .-typography .-fontSize) 24)
(set! (-> theme .-typography .-body2 .-fontSize) "1rem")
(set! (-> theme .-typography .-body1 .-fontSize) "1rem")
(set! (-> theme .-typography .-body2 .-fontFamily) set-new-font)
(set! (-> theme .-typography .-body1 .-fontFamily) set-new-font)
(defn print-typo [] (js/console.log (-> theme .-typography)))
(js/console.log (-> theme .-spacing .-unit))

(def styles {:root {:flex-grow "1"
                    :margin-bottom "20px"}
             :flex {:flex "1"}
             :menu-button {:margin-left "-12px"
                           :margin-right "20px"}
             :cont-center {:display "flex"
                           :justify-content "center"
                           :width "100%"}
             :card {:width "99%"
                    :margin-top "10px"
                    :margin-bottom "50px"}

             :media {:height "0px"
                     :padding-top "56.25%"}
             :actions {:display "flex"}
             :expand {:margin-left "auto"}
                      ; :transform "rotate(0deg)"
                      ; :transition

             :avatar {:background-color "red"}
             :paper {;:height "200px"
                     ;:width "100%"
                     ;:min-width "200px"
                     ;:flex-basis "0"
                     ;:flex-grow "1"
                     ;:background-color "red"
                     :text-align "left"
                     :padding (* 2 (-> theme .-spacing .-unit))
                     :color (-> theme .-palette .-text .-secondary)
                     :background-color (-> theme .-palette .-primary .-light)}

             :contein-temp {;:background-color (-> theme .-palette .-primary .-light)
                            :height "100px"
                            :width "100%"}

             :text-fild-style {:with "400px"}})

(defn info-block-main []
  (let [];travel-data @(re-frame/subscribe [:sub-event-data  "travel001"])]
    [:> Grid {:container true
              :spacing 8
              :style {:display "flex" :justify-content "space-between"}} ;;main information block: when&where
     [:> Grid {:item true :xs 12 :sm 6 :md 4
               :style {:padding "10px 0px 10px 20px"}} ;; information  when?
      [:> Typography {:color "textSecondary" :variant "title" :align "left" :gutterBottom true}
        "kiedy?"]
      [:> Typography {:color "primary" :variant "headline"}
        (str "25-01-2018" #_(:travel/data travel-data))]
      [:> Typography {:color "primary" :variant "subheading"}
        "poniedziałek"]
      [:> Typography {:color "secondary" :variant "subheading"}
        "za 6 d."]]
     [:> Hidden {:xlDown true}]
     [:> Grid {:item true :xs 12 :sm 6 :md 4
               :style {:display "flex"
                       :flex-direction "column"
                       :justify-content "flex-start"
                       :padding "10px 20px 10px 0px"}} ;; information  where?
      [:> Typography {:color "textSecondary" :variant "title" :align "right" :gutterBottom true}
        "dokąd?"]
      [:> Typography {:color "primary" :variant "display1" :align "right"  :style {:flex-grow 2}}
        "Jańskie Łaźnie"]
      [:> Typography {:variant "button" :align "right" :style {:color (-> theme .-palette .-text .-primary)}}
        [:a {:href ""}
          "mapa"]]]]))

(defn info-block-about []
  (let [loc-grids {:el-01 {:xs 6 :sm 2 :md 2 :lg 1}
                   :el-02 {:xs 5 :sm 1 :md 1 :lg 1}
                   :el-03 {:xs 1 :sm 1 :md 1 :lg 1 :align "center"}
                   :el-04 {:xs false :sm 1 :md 1 :lg 1}
                   :el-05 {:xs 12 :sm 6 :md 4 :lg 2}}
        text-format {:form-01 {:color "default" :variant "body2" :style {:padding-left "10px"}}
                     :form-02 {:color "primary" :variant "subheading"}
                     :form-03 {:color "default" :variant "body1" :style {:padding-left "10px"}}}
        contain-format {:cont-form {:container true :spacing 8 :style {:margin-bottom "20px"}}}]
    [:> Grid {:container true :spacing 16} ;; second information block
     [:> Grid (conj {} (:cont-form contain-format));; info about time and place of start
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "wyjazd"]]

      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "6:00"]]

      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> HelpOutlineIcon]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))]
      [:> Grid (conj {:item true} (:el-05 loc-grids))
       [:> Typography (conj {} (:form-03 text-format))  "McD Factory (Wrocław) "
        [:a {:href ""} "mapa"]]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about time and place of return
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "powrot"]]

      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "20:00"]]

      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> HelpOutlineIcon]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))]
      [:> Grid (conj {:item true} (:el-05 loc-grids))
       [:> Typography (conj {} (:form-03 text-format)) "McD Factory (Wrocław) "
        [:a {:href ""} "mapa"]]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about road time&distance
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "w drodze"]]

      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "2,5 h"]]

      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> HelpOutlineIcon]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))]
      [:> Grid (conj {:item true} (:el-05 loc-grids))
       [:> Typography (conj {} (:form-03 text-format)) "odległoć 150 km"]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about staeing on slop
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Typography (conj {:style {:padding-left "10px"}} (:form-01 text-format)) "na stoku"]]

      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "8 h"]]

      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> HelpOutlineIcon]]]]))

(defn info-block-contact-person []
  [:> Grid {:container true :direction "row" :spacing 16}
   [:> Grid {:item true :xs 12 :sm 12 :lg 4 :style {:padding-left "10px"}}
    [:> Typography {:variant "subheading"} "Osoba kontaktowa"]]
   [:> Grid {:item true :xs 6 :sm 5 :lg 4 :style {:padding-left "10px"}}
    [:> Typography {:variant "title"} "Jacek"]]
   [:> Grid {:item true :xs 6 :sm 7  :lg 4 :style {:padding-left "10px"}}
    [:> Typography {:variant "body2"} "{kontakt do Jacka}"]]])

(defn info-block-auto []
  [:> Grid {:container true :direction "row" :spacing 16}
   [:> Grid {:item true :xs 12 :sm 12 :lg 4 :style {:padding-left "10px"}}
    [:> Typography {:variant "subheading"} "Samochod"]]
   [:> Grid {:item true :xs 12 :sm 5 :lg 4 :style {:padding-left "10px"}}
    [:> Typography {:variant "title"} "VW T4 transporter"]
    [:> Typography {:variant "body1"} "ilosc miejsc 5"]
    [:> Typography {:variant "body1"} "kolor czerwony"]
    [:> Typography {:variant "body1"} "{opis dodatkowy}"]]

   [:> Grid {:item true :xs 12 :sm 7  :lg 4 :style {:padding-left "10px"}}
    [:div "{foto auta}hh"]]])

(defn info-block-divider []
  [:> Divider {:light false  :style {:width "100%" :margin "10px 0px 20px 0px"}}])

(defn info-block-passengers-table []
  (let [loc-grids {:el-01 {:xs 2 :sm 1 :md 1 :align "center"}
                   :el-02 {:xs 5 :sm 3 :md 3}
                   :el-03 {:xs 5 :sm 4 :md 3}
                   :el-04 {:xs 12 :sm 4 :md 3 :align "center"}
                   :el-05 {}}
        text-format {:form-01 {:color "default" :variant "body2" :style {:padding-left "10px"}}
                     :form-02 {:color "primary" :variant "title"}
                     :form-03 {:color "default" :variant "body1" :style {:padding-left "10px"}}}
        contain-format {:cont-form {:container true :spacing 8 :style {:margin-bottom "15px"}}}]
    [:> Grid (conj {:style {:padding "10px 0px 0px 10px"}} (:cont-form contain-format)) ;; list of passengers information block
     [:> Grid (conj {} (:cont-form contain-format)) ;; info about Jacek
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Avatar {:style {:margin-top "-10px"}} "J"]]
      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "Jacek"]]
      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "kierowca"]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "potwierdzono"]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about Zofia
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Avatar {:style {:margin-top "-5px"}} "Z"]]
      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "Zofia"]]
      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "pasażer"]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "potwierdzono"]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about Hania
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Avatar {:style {:margin-top "-5px"}} "H"]]
      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "Hania"]]
      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "pasażer"]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "nie potwierdzono"]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; info about Olek
      [:> Grid (conj {:item true} (:el-01 loc-grids))
       [:> Avatar {:style {:margin-top "-5px"}} "O"]]
      [:> Grid (conj {:item true} (:el-02 loc-grids))
       [:> Typography (conj {} (:form-02 text-format)) "Olek"]]
      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "pasażer"]]
      [:> Grid (conj {:item true} (:el-04 loc-grids))
       [:> Typography (conj {} (:form-01 text-format)) "zaproszono"]]]

     [:> Grid (conj {} (:cont-form contain-format)) ;; input fild new-passenger
      [:> Grid (conj {:item true} (:el-01 loc-grids))]
      [:> Grid (conj {:item true} (:el-03 loc-grids))
       [:> TextField {:id "with-placeholder"
                      :label "Dodaj pasażera"
                      :placeholder "wpisz imię"
                      :style (:text-fild-style styles)

                      :margin "dense"}
        "dodawanie pasażera"]]]]))

(defn event-card []
  [:div {:style (:cont-center styles)}
   [:> Card {:style (:card styles)}
    [:> CardContent

     [:div {:style (:root styles)}
      [:> Grid {:container true :spacing 16}
       [info-block-main] [info-block-divider]
       [info-block-about] [info-block-divider]
       [info-block-contact-person] [info-block-divider]
       [info-block-auto] [info-block-divider]
       [info-block-passengers-table]]]]]]); [:> Typography {:component "p"}
     ;      "This impressive paella is a perfect party dish and a fun meal to cook together
     ;       with your guests. Add 1 cup of frozen peas along with the mussels, if you like."]
     ; ]
     ; [:> CardActions {:style (:actions styles)
     ;                  :disable-action-spacing false
     ;                  }
     ;    [:> IconButton {:aria-label "Add to favorites"}
     ;      [:> FavoriteIcon]]
     ;    [:> IconButton {:aria-label "Share"}
     ;      [:> ShareIcon]]
     ;    [:> IconButton {:aria-label "Show more"
     ;                    :style (:expand styles)
     ;                    ;:on-click
     ;                    ;:aria-expanded
     ;                    }
     ;      [:> ExpandMoreIcon]]]
     ; [:> Collapse {:in true}
     ;   [:> CardContent
     ;     [:> Typography {;:paragraph ""
     ;                     :variant "body2"}
     ;       "Method:"]
     ;     [:> Typography {;:paragraph true
     ;                     }
     ;       "Heat 1/2 cup of the broth in a pot until simmering, add saffron and set aside
     ;         for 10 minutes."]
     ;     [:> Typography {;:paragraph true
     ;                     }
     ;       "Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over medium-high
     ;            heat. Add chicken, shrimp and chorizo, and cook, stirring occasionally until lightly
     ;            browned, 6 to 8 minutes. Transfer shrimp to a large plate and set aside, leaving
     ;            chicken and chorizo in the pan. Add pimentón, bay leaves, garlic, tomatoes, onion,
     ;            salt and pepper, and cook, stirring often until thickened and fragrant, about 10
     ;            minutes. Add saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil."]
     ;     [:> Typography {;:paragraph true
     ;                     }
     ;       "Add rice and stir very gently to distribute. Top with artichokes and peppers, and
     ;            cook without stirring, until most of the liquid is absorbed, 15 to 18 minutes.
     ;            Reduce heat to medium-low, add reserved shrimp and mussels, tucking them down into
     ;            the rice, and cook again without stirring, until mussels have opened and rice is
     ;            just tender, 5 to 7 minutes more. (Discard any mussels that don’t open.)"]
     ;     [:> Typography
     ;       "Set aside off of the heat to let rest for 10 minutes, and then serve."]
     ;     ]
(defn new-user []
 (re-frame/dispatch [::events/add-new-user "user017"]))

(defn app-bar []
  [:> AppBar {:position "static"}
   [:> Toolbar
    [:> IconButton {:style (:menu-button styles)
                    :color "inherit"
                    :aria-label "Menu"}
     [:> MenuIcon]]
    [:> Button {:color "inherit" :on-click #(new-user)} "New user"]
    [:> Typography {:variant "title"
                    :color "inherit"
                    :style (:flex styles)}
     "Razem Na Stok"]
    [:> Button {:color "inherit"}
     "Login"]]])

(defn main-panel []
  [:> MuiThemeProvider (do
                         ;(js/console.log (-> theme .-typography))
                         (conj {} {:theme theme}))
   [:div {:style (:root styles)}

    [app-bar]
    [event-card]]])





;; (defn tabel-row-passenger [])


;; (defn passenger-entry []
;;   (let [pas-name (r/atom "")]
;;     (fn []
;;       [:div {:style {:padding "5px"
;;                      :display "flex"
;;                      :justify-content "space-between"
;;                       :align-items "center"}}
;;                   [ui/text-field {:hint-text "wpisz imię"
;;                                   :floating-label-text "pasażer 3"
;;                                   :type "text"
;;                                   :value @pas-name
;;                                   :on-change #(reset! pas-name (-> % .-target .-value))
;;                                   ; :on-save #(when (seq %)
;;                                   ;             (re-frame/dispatch [:add-passenger %]))
;;                                   :on-save (fn [args] (js/console.log args))
;;                                   }]
;;                   [ui/floating-action-button {:mini true
;;                                               :primary true
;;                                               :on-click #(when (seq @pas-name)
;;                                                              (re-frame/dispatch [:add-passenger @pas-name]))}
;;                     [ic/content-add]]])))

;; (defn person-view [name status]
;;   [ui/table-row
;; 		[ui/table-row-column name]
;; 		 [ui/table-row-column status]])

;; (defn cards-with-passangers []
;;  (let [driver @(re-frame/subscribe [:driver])
;;        passengers @(re-frame/subscribe [:passengers])]
;;           [ui/card-text
;; 	          [ui/table ;{:display-row-checkbox false}
;; 	             [ui/table-header {:display-select-all false
;; 	                              :adjust-for-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-header-column "imię"]
;; 	                [ui/table-header-column "status"]]]
;; 	            [ui/table-body {:display-row-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-row-column (get driver :name)]
;; 	                 [ui/table-row-column "kierowca"]]
;; 								(map-indexed
;;                    (fn [idx person] [person-view (:name person)
;;                                      (str "pasażer " (inc idx))])
;;                   passengers)]]
;; 	           [passenger-entry]]))

;; (defn car-card []
;;   (let []
;;     (fn []
;;       [ui/card {:style {:margin "10px 0px"}}
;;         [:div.destination {:style {:padding "5px"
;;                         :display "flex"
;;                         :justify-content "space-between"
;;                        :align-items "center"}}
;;            [ui/card-title {:title "VW T4"
;;                           :subtitle (str "czerwony" ", " "Blueberry Machine" ", " "miejsc razem " "5")
;;                           :style {:padding "5px"}}]
;;            ;(avatarN)
;;           [ui/badge {:badge-content "3"
;;                      :primary true
;;                       :style {:display "flex"
;;                      ;:flex-grow "2"
;;                      :padding "12px 12px 12px 12px"}}
;;             [ui/avatar {:color (color :deepOrange300)
;;                         :backgroundcolor (color :purple500)
;;                         ;:size "80"
;;                         :margin "0px"
;;                         :children "2"
;;                          }
;;               ]]
;;           ]
;;         [ui/divider]
;; 				[cards-with-passangers]
;;        ])))


;; (defn home-panel []
;;   (let [name (re-frame/subscribe [::subs/name])]

;;      ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
;;      [ui/mui-theme-provider {:mui-theme (get-mui-theme
;;                                          ;(aget js/MaterialUIStyles "DarkRawTheme")
;;                                          )}
;;          [:div
;;            [app-bar]
;;            ;[jumbotron]

;;           [destination-card]
;;            [car-card]
;;           [:a {:href "#/about"} "go to About Page"]


;;         ]
;;       ]
;;      ))


;; ;; about

;; (defn about-panel []
;;   [:div "This is the About Page."
;;    [:div [:a {:href "#/"} "go to Home Page"]]])


;; ;; main

;; (defn- panels [panel-name]
;;   (case panel-name
;;     :home-panel [home-panel]
;;     :about-panel [about-panel]
;;     [:div]))

;; (defn show-panel [panel-name]
;;   [panels panel-name])

;; (defn main-panel []
;;   (let [active-panel (re-frame/subscribe [::subs/active-panel])]
;;     [show-panel @active-panel]))
